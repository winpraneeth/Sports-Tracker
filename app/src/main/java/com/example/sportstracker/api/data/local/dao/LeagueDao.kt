package com.example.sportstracker.api.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sportstracker.api.data.local.entity.LeagueEntity

@Dao
interface LeagueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLeagues(leagueEntities: List<LeagueEntity?>?)

    @Query("SELECT * FROM leagues")
    fun loadAllLeagueNames(): LiveData<List<LeagueEntity>>
}