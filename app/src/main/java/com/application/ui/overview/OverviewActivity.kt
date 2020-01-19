package com.application.ui.overview

import android.os.Bundle
import android.util.TypedValue
import androidx.navigation.findNavController
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
        setupAddIconBottomNavBar()

    }

    private fun setUpNavigation() {
        NavigationUI.setupWithNavController(
            bottom_navigation,
            nav_host_fragment.findNavController()
        )

//        fab.setOnClickListener { nav_host_fragment.findNavController().navigate() }
    }

    private fun setupAddIconBottomNavBar() {
//        val addIcon = bottom_navigation.getChildAt(bottom_navigation.childCount / 2)
//        val displayMetrics = resources.displayMetrics
//        val iconParams = addIcon.layoutParams
//        iconParams.apply {
//            height =
//                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32f, displayMetrics).toInt()
//            width =
//                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32f, displayMetrics).toInt()
//        }
//        addIcon.layoutParams = iconParams
    }
}