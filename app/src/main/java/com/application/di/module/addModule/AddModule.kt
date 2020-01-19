package com.application.di.module.addModule

import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.application.di.ViewModelKey
import com.application.di.module.ViewModelAssistedFactory
import com.application.ui.add.AddFragment
import com.application.ui.add.AddViewModel
import com.application.ui.overview.OverviewActivity
import com.application.ui.overview.OverviewViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AddModule{

    @Binds
    @IntoMap
    @ViewModelKey(AddViewModel::class)
    abstract fun bindFactory(viewModel: AddViewModel.Factory): ViewModelAssistedFactory<out ViewModel>
}