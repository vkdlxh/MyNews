package com.archive.mynews

import android.app.Application
import com.archive.mynews.common.PreferenceHelper

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.init(this)
    }
}