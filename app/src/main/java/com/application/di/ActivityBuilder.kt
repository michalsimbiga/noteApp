package com.application.di

import com.application.di.module.addModule.AddMainModule
import com.application.di.module.addModule.AddModule
import com.application.di.module.overviewModule.OverviewMainModule
import com.application.di.module.overviewModule.OverviewModule
import com.application.ui.overview.OverviewActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            OverviewMainModule::class,
            OverviewModule::class,
            AddMainModule::class,
            AddModule::class]
    )
    abstract fun bindOverviewActivity(): OverviewActivity
}