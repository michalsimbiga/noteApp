package com.application.di.module.addModule

import com.application.ui.add.AddFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AddMainModule {

    @ContributesAndroidInjector
    abstract fun bindAddFragment(): AddFragment
}