package com.application.di.module.overviewActivity

import com.application.ui.overview.OverviewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class OverviewActivityModule {

    @ContributesAndroidInjector
    abstract fun bindOverviewFragment(): OverviewFragment
}