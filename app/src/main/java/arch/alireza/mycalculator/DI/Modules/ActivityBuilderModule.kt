package arch.alireza.mycalculator.DI.Modules

import arch.alireza.mycalculator.MainScreen.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun countributeMainActivity() : MainActivity

}