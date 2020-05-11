package com.example.sportstracker.api.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sportstracker.api.data.local.dao.LeagueDao
import com.example.sportstracker.api.data.local.entity.LeagueEntity

@Database(entities = [LeagueEntity::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun leagueDao(): LeagueDao
}