package arch.alireza.mycalculator.DI.Components

import android.app.Application
import arch.alireza.mycalculator.DI.Modules.ActivityBuilderModule
import arch.alireza.mycalculator.DI.Modules.appModule
import arch.alireza.mycalculator.DI.MyApp
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