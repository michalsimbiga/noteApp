package com.application.presentation.overview

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.application.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_overview.*

class OverviewActivity : DaggerAppCompatActivity() {

    private val navController by lazy { nav_host_fragment.findNavController() }
    private val toolbar by lazy { activity_overview_toolbar }
    private val appBarConfig by lazy { AppBarConfiguration(navController.graph) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_overview)

        setSupportActionBar(toolbar)
        setupBottomNav()
        setupToolbarWithNav()
    }

    private fun setupBottomNav() = bottom_navigation.setupWithNavController(navController)
    private fun setupToolbarWithNav() = toolbar.setupWithNavController(navController, appBarConfig)
}