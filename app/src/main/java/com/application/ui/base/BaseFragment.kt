package com.application.ui.base

import androidx.lifecycle.ViewModelProvider
import com.application.vm.AssistedViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

open class BaseFragment: DaggerFragment() {

    @Inject lateinit var vmFactory: ViewModelProvider.Factory
    @Inject lateinit var savedStateVMFactory: AssistedViewModelFactory
}