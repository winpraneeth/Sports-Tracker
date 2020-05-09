package com.example.sportstracker.di.module

import com.example.sportstracker.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindsMainActivity(): MainActivity?
}