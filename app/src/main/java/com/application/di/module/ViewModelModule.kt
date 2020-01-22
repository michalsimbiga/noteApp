package com.application.di.module

import androidx.lifecycle.ViewModel
import com.application.di.ViewModelKey
import com.application.repository.MyRepository
import com.application.ui.overview.OverviewViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

//    @Provides
//    @IntoMap
//    @ViewModelKey(
//    fun ticketsOverviewActivityViewModel(repository: MyRepository): ViewModel =
//        TicketsOverviewActivityViewModel(repository)

    @Provides
    @IntoMap
    @ViewModelKey(OverviewViewModel::class)
    fun overviewViewModel(repo: MyRepository): ViewModel = OverviewViewModel(repo)
}