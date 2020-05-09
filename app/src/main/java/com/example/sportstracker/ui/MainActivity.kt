package com.example.sportstracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sportstracker.R
import com.example.sportstracker.base.BaseActivity
import com.example.sportstracker.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override val layoutRes: Int
        get() = R.layout.activity_main
}
