package com.application.di.module.overviewModule

import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.application.di.ViewModelKey
import com.application.di.module.ViewModelAssistedFactory
import com.application.ui.overview.OverviewActivity
import com.application.ui.overview.OverviewViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class OverviewModule{

    @Binds
    @IntoMap
    @ViewModelKey(OverviewViewModel::class)
    abstract fun bindFactory(viewModel: OverviewViewModel.Factory): ViewModelAssistedFactory<out ViewModel>

    @Binds
    abstract fun bindSavedStateRegistyOwner(overviewActivity: OverviewActivity): SavedStateRegistryOwner
}