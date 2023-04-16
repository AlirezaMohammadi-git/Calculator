package com.example.mycalculator.DI.Components

import android.app.Application
import com.example.mycalculator.DI.Modules.ActivityBuilderModule
import com.example.mycalculator.DI.Modules.appModule
import com.example.mycalculator.DI.MyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        appModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class]
)
interface MainComponent : AndroidInjector<MyApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): MainComponent
    }

}