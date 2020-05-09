package com.example.sportstracker.di.module

import com.example.sportstracker.ui.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindsMainFragment(): MainFragment
}