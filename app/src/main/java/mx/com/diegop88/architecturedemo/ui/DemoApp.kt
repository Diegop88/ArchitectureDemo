package mx.com.diegop88.architecturedemo.ui

import android.app.Application
import mx.com.diegop88.architecturedemo.di.appModule
import org.koin.android.ext.android.startKoin

class DemoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}
