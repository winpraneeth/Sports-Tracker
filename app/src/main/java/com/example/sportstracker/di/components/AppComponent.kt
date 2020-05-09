package com.example.sportstracker.di.components

import android.app.Application
import com.example.sportstracker.SportsTrackerApp
import com.example.sportstracker.di.module.ActivityModule
import com.example.sportstracker.di.module.AppModule
import com.example.sportstracker.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityModule::class, NetworkModule::class, AndroidInjectionModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder
        fun build(): AppComponent
    }

    fun inject(sportsTrackerApp: SportsTrackerApp)
}