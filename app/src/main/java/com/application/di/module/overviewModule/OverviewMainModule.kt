package com.application.di.module.overviewModule

import com.application.ui.overview.OverviewFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class OverviewMainModule {

    @ContributesAndroidInjector
    abstract fun bindOverviewFragment(): OverviewFragment
}