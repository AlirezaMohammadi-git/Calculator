package com.example.mycalculator.DI.Modules

import com.example.mycalculator.MainScreen.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun countributeMainActivity() : MainActivity

}