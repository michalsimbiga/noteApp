package com.application

import android.os.StrictMode
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.application.di.DaggerAppComponent
import dagger.android.DaggerApplication
import timber.log.Timber
import timber.log.Timber.DebugTree

class MyApplication : DaggerApplication() {

    private val applicationInjector = DaggerAppComponent
        .builder()
        .application(this)
        .build()

    public override fun applicationInjector() = applicationInjector

    override fun onCreate() {
        super.onCreate()

        setupStrictMode()
        setupDagger()
        setupTimber()
    }

    private fun setupDagger() {
        DataBindingUtil.setDefaultComponent(applicationInjector
            .bindingComponentBuilder()
            .build()
        )
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    private fun setupStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
        }
    }

    private class ReleaseTree : Timber.Tree() {

        override fun isLoggable(tag: String?, priority: Int): Boolean {
            if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
                return false
            }
            return true
        }

        //TODO: add support for logging framework
        override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
            if (!isLoggable(tag, priority)) {
                return
            }

            if (priority == Log.WARN) {
                Log.w(tag, message)
            } else if (priority == Log.ERROR) {
                Log.e(tag, message)
            }
        }
    }
}