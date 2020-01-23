package com.application.ui.overview

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.application.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_overview.*

class OverviewActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_overview)
        setSupportActionBar(activity_overview_toolbar)

        setUpNavigation()
        setupToolbarWithBottomNav()
    }

    private fun setUpNavigation() {
        NavigationUI.setupWithNavController(
            bottom_navigation,
            nav_host_fragment.findNavController()
        )
    }

    private fun setupToolbarWithBottomNav() {
        NavigationUI.setupActionBarWithNavController(this, nav_host_fragment.findNavController())
    }

    private fun setUpToolbar(
        toolbar: Toolbar,
        toolbarTitle: String
    ) {
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
            toolbar.title = toolbarTitle
        }
    }
}