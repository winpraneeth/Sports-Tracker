package com.example.sportstracker.di.module

import android.content.Context
import com.example.sportstracker.SportsTrackerApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: SportsTrackerApp): Context? {
        return application.applicationContext
    }
}