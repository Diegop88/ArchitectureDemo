package mx.com.diegop88.architecturedemo.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mx.com.diegop88.architecturedemo.ui.main.MainActivity
import mx.com.diegop88.architecturedemo.ui.main.MainModule

@Module
interface AppBinder {
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity
}
