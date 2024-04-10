package com.Rishabh Prajapati.photoalbum

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.Rishabh Prajapati.photoalbum.addon.AddOnManager

class MainApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        // Enable vector support.
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        // Initialize AddOnManager.
        AddOnManager.initialize(this)
    }

    override fun onTerminate() {
        // Clear AddOnManager.
        AddOnManager.clearAddOns()
        super.onTerminate()
    }
}