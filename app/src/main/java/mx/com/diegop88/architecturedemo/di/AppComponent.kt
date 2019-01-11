package mx.com.diegop88.architecturedemo.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import mx.com.diegop88.architecturedemo.ui.DemoApp
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    AppBinder::class])
interface AppComponent : AndroidInjector<DemoApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DemoApp>()
}
