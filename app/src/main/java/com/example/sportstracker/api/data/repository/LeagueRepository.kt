package com.example.sportstracker.api.data.repository

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import com.example.sportstracker.api.NetworkBoundResource
import com.example.sportstracker.api.Resource
import com.example.sportstracker.api.SportsDbApi
import com.example.sportstracker.api.data.local.AppDatabase
import com.example.sportstracker.api.data.local.dao.LeagueDao
import com.example.sportstracker.api.data.local.entity.LeagueEntity
import com.example.sportstracker.api.data.model.LeagueResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LeagueRepository @Inject internal constructor(val leagueDao: LeagueDao, val sportsDbApi: SportsDbApi) {


//    var sportsDbApi: SportsDbApi = service
//    var leagueDao: LeagueDao = dao

    /**
     * This method fetches the popular articles from the service.
     * Once the fetching is done the data is cached to local db so that the app can even work offline
     * @return List of articles
     */
//    fun loadLeagues(): LiveData<Resource<List<LeagueEntity>?>> {
//        return object :
//            NetworkBoundResource<List<LeagueEntity>, LeagueResponse?>() {
//             override fun saveCallResult(item: LeagueResponse?) {
//                if (null != item) leagueDao.saveLeagues(item.getLeagues())
//            }
//
//            @NonNull
//             override fun loadFromDb(): LiveData<List<LeagueEntity>> {
//                return leagueDao.loadAllLeagueNames()
//            }
//
//            @NonNull
//             override fun createCall(): Call<LeagueResponse?> {
//                return sportsDbApi.loadLeagues()
//            }
//        }.asLiveData
//    }

    fun loadLeagues() {
        sportsDbApi.loadLeagues().enqueue(object : Callback<LeagueResponse> {
            override fun onResponse(call: Call<LeagueResponse>, response: Response<LeagueResponse>) {
                if (response.body() != null) {
                    val leagues = response.body() as LeagueResponse
                }
            }

            override fun onFailure(call: Call<LeagueResponse>, t: Throwable) {

            }
        })
    }

}
