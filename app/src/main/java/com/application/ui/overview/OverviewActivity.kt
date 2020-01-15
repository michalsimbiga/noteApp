package com.application.ui.overview

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.application.R
import com.application.ui.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_overview.*

class OverviewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_overview)
        setUpNavigation()
    }

    private fun setUpNavigation() {
//        NavigationUI.setupWithNavController(
//            bottom_navigation,
//            nav_host_fragment.findNavController()
//        )
    }
}