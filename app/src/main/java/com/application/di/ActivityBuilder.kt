package com.application.di

import com.application.di.module.overviewActivity.OverviewActivityModule
import com.application.di.module.overviewActivity.OverviewModule
import com.application.ui.overview.OverviewActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            OverviewActivityModule::class,
            OverviewModule::class]
    )
    abstract fun bindOverviewActivity(): OverviewActivity
}