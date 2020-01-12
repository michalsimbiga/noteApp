package com.application.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.application.R
import com.application.ui.base.BaseFragment

class OverviewFragment: BaseFragment() {

    private val viewModel: OverviewViewModel by viewModels { savedStateVMFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_overview, container, false)
}