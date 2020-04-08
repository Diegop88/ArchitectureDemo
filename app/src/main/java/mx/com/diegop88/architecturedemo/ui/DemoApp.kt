package mx.com.diegop88.architecturedemo.ui

import android.app.Application
import mx.com.diegop88.architecturedemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DemoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DemoApp)
            modules(appModule)
        }
    }
}
