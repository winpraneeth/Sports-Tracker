package com.example.sportstracker.api.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "leagues")
class LeagueEntity {
    @PrimaryKey
    @SerializedName("idLeague")
    var id: Long = 0

    @SerializedName("strLeague")
    var leagueName: String? = null

    @SerializedName("strSport")
    var sportName: String? = null

}