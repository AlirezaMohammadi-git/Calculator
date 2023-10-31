package arch.alireza.mycalculator.DI

import arch.alireza.mycalculator.DI.Components.DaggerMainComponent
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