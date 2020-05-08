package com.example.sportstracker

import android.app.Activity
import android.app.Application
import com.example.sportstracker.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class SportsTrackerApp: Application(), HasActivityInjector {

    private var instance: SportsTrackerApp? = null

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Synchronized
    private fun setInstance() {
        instance = this
    }

    fun getContext(): SportsTrackerApp? {
        return instance
    }

    override fun onCreate() {
        super.onCreate()
        initializeComponent()
        setInstance()
    }

    private fun initializeComponent() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity?>? {
        return dispatchingAndroidInjector
    }
}