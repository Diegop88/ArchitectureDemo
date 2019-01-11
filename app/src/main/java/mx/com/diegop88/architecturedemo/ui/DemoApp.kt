package mx.com.diegop88.architecturedemo.ui

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import mx.com.diegop88.architecturedemo.di.DaggerAppComponent

class DemoApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().create(this)
}
