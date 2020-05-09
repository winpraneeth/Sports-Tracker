package com.example.sportstracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sportstracker.R
import com.example.sportstracker.base.BaseFragment
import com.example.sportstracker.databinding.FragmentMainBinding
import com.example.sportstracker.viewmodel.LeagueListViewModel

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : BaseFragment<LeagueListViewModel, FragmentMainBinding>() {


    override fun getViewModel(): Class<LeagueListViewModel> {
        return LeagueListViewModel::class.java
    }

    override val layoutRes: Int
        get() = R.layout.fragment_main

}
