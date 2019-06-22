package mx.com.diegop88.architecturedemo.di

import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine
import mx.com.diegop88.architecturedemo.ui.main.MainViewModel
import mx.com.diegop88.shareddemo.data.DemoService
import mx.com.diegop88.shareddemo.domain.repositories.DemoRepository
import mx.com.diegop88.shareddemo.domain.usecases.GetAllCountries
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val engine = OkHttpEngine(OkHttpConfig())
private val service = DemoService(engine)

val appModule = module {
    single { DemoRepository(service) }
    factory { GetAllCountries(get()) }
    viewModel { MainViewModel(get()) }
}
