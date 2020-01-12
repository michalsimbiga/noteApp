package com.application.ui.base

import com.application.vm.AssistedViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity: DaggerAppCompatActivity() {

    @Inject lateinit var savedStateVMFactory: AssistedViewModelFactory
}