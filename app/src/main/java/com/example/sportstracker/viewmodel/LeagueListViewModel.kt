package com.example.sportstracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sportstracker.api.Resource
import com.example.sportstracker.api.data.local.entity.LeagueEntity
import com.example.sportstracker.api.data.repository.LeagueRepository
import javax.inject.Inject

class LeagueListViewModel @Inject constructor(leagueRepository: LeagueRepository) :
    ViewModel() {

    private val leagues: LiveData<Resource<List<LeagueEntity>?>> = leagueRepository.loadLeagues()
    fun getleagues(): LiveData<Resource<List<LeagueEntity>?>> {
        return leagues
    }

}