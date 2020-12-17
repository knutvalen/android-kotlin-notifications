package com.example.android.eggtimernotifications

import android.app.Application
import timber.log.Timber

class AppDelegate : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}