package com.example.sportstracker.api

import com.example.sportstracker.api.data.model.LeagueResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SportsDbApi {

    @GET("/api/v1/json/1/all_leagues.php")
    fun loadLeagues(): Call<LeagueResponse>
}