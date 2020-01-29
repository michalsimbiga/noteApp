package com.application.di

import com.application.presentation.add.AddFragment
import com.application.presentation.overview.OverviewActivity
import com.application.presentation.overview.OverviewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindOverviewActivity(): OverviewActivity

    @ContributesAndroidInjector
    abstract fun bindAddFragment(): AddFragment

    @ContributesAndroidInjector
    abstract fun bindOverviewFragment(): OverviewFragment
}