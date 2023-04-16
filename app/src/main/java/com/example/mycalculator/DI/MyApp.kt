package com.example.mycalculator.DI

import android.app.Application
import android.util.Log
import com.example.mycalculator.DI.Components.DaggerMainComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class MyApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMainComponent
            .builder()
            .application(this)
            .build()
    }

}