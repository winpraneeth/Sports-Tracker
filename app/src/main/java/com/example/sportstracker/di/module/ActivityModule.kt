package com.example.sportstracker.di.module

import com.example.sportstracker.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun bindsMainActivity(): MainActivity?
}