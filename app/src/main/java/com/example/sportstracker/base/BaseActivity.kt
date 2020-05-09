package com.example.sportstracker.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity<D : ViewDataBinding> : AppCompatActivity(),
    HasSupportFragmentInjector {
    @Inject
    lateinit var fragmentAndroidInjector: DispatchingAndroidInjector<Fragment>
    var dataBinding: D? = null

    @get:LayoutRes
    protected abstract val layoutRes: Int
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutRes)
    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {
        return fragmentAndroidInjector
    }
}