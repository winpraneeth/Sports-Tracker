package com.example.sportstracker.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.sportstracker.SportsTrackerApp
import com.example.sportstracker.api.data.local.AppDatabase
import com.example.sportstracker.api.data.local.dao.LeagueDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "my.db").build()
    }


    @Provides
    @Singleton
    fun provideLeagueDao(appDatabase: AppDatabase): LeagueDao {
        return appDatabase.leagueDao()
    }
}