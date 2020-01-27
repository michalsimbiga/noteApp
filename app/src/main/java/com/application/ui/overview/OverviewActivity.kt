package com.application.ui.overview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
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
        setupActionBarWithNavController(navController, appBarConfig)
        NavigationUI.setupWithNavController(bottom_navigation, navController)
        toolbar.setupWithNavController(navController, appBarConfig)
    }
}