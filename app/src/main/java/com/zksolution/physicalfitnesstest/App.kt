package com.zksolution.physicalfitnesstest

import android.app.Application
import com.zksolution.physicalfitnesstest.di.AppComponent
import com.zksolution.physicalfitnesstest.di.DaggerAppComponent

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}