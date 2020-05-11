package com.example.sportstracker.api

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.sportstracker.api.Resource.Companion.loading
import com.example.sportstracker.api.Resource.Companion.success
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


abstract class NetworkBoundResource<T, V> @MainThread protected constructor() {
    private val result =
        MediatorLiveData<Resource<T?>>()

    /**
     * This method fetches the data from remoted service and save it to local db
     * @param dbSource - Database source
     */
    private fun fetchFromNetwork(dbSource: LiveData<T>) {
        result.addSource(
            dbSource
        ) { newData: T ->
            result.setValue(
                loading(newData)
            )
        }
        createCall().enqueue(object : Callback<V> {
            override fun onResponse(
                call: Call<V>,
                response: Response<V>
            ) {
                result.removeSource(dbSource)
                saveResultAndReInit(response.body())
            }

            override fun onFailure(
                call: Call<V>,
                t: Throwable
            ) {
                result.removeSource(dbSource)
                //           result.addSource(dbSource, newData -> result.setValue(Resource.error(getCustomErrorMessage(t), newData)));
            }
        })
    }

    @SuppressLint("StaticFieldLeak")
    @MainThread
    private fun saveResultAndReInit(response: V?) {
        object : AsyncTask<Void, Void?, Void?>() {
            protected override fun doInBackground(vararg voids: Void): Void? {
                saveCallResult(response)
                return null
            }

            override fun onPostExecute(aVoid: Void?) {
                result.addSource(
                    loadFromDb()
                ) { newData: T? ->
                    if (null != newData) result.setValue(
                        success(
                            newData
                        )
                    )
                }
            }
        }.execute()
    }

    @WorkerThread
    protected abstract fun saveCallResult(item: V?)

    @MainThread
    private fun shouldFetch(): Boolean {
        return true
    }

    @MainThread
    protected abstract fun loadFromDb(): LiveData<T>

    @MainThread
    protected abstract fun createCall(): Call<V>
    val asLiveData: LiveData<Resource<T?>>
        get() = result

    init {
        result.value = loading(null)

        // Always load the data from DB intially so that we have
        val dbSource = loadFromDb()
        // Fetch the data from network and add it to the resource
        result.addSource(dbSource) { data: T ->
            result.removeSource(dbSource)
            if (shouldFetch()) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(
                    dbSource
                ) { newData: T? ->
                    if (null != newData) result.value = success(
                        newData
                    )
                }
            }
        }
    }
}