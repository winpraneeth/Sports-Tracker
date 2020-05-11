package com.example.sportstracker.api.data.model

import com.example.sportstracker.api.data.local.entity.LeagueEntity
import com.google.gson.annotations.SerializedName

class LeagueResponse {

    @SerializedName("leagues")
    private var leagues: List<LeagueEntity?>? = null


    /**
     * This method return the list of league entities
     * @return List of entities
     */
    fun getLeagues(): List<LeagueEntity?>? {
        return leagues
    }

    /**
     * This method sets the league entities
     * @param leagues - leagueslist
     */
    fun setLeagues(leagues: List<LeagueEntity?>?) {
        this.leagues = leagues
    }
}