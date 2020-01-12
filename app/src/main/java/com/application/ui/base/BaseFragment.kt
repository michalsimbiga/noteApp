package com.application.ui.base

import com.application.vm.AssistedViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {

    @Inject lateinit var savedStateVMFactory: AssistedViewModelFactory
}