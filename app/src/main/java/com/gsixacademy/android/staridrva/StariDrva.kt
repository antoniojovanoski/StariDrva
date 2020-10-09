package com.gsixacademy.android.staridrva

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.gsixacademy.android.staridrva.utils.LocaleManager

class StariDrva():Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(LocaleManager.setLocale(base))
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManager.setLocale(this)
    }
}