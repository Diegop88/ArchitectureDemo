package mx.com.diegop88.architecturedemo.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import mx.com.diegop88.architecturedemo.data.DemoService
import mx.com.diegop88.architecturedemo.domain.repositories.DemoRepository
import mx.com.diegop88.architecturedemo.domain.usecases.GetAllCountries
import mx.com.diegop88.architecturedemo.ui.main.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE = "https://restcountries.eu/"

private val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE)
    .client(client)
    .build()

private val demoService = retrofit.create(DemoService::class.java)

val appModule = module {
    single { demoService }
    single { DemoRepository(demoService = get()) }
    factory { GetAllCountries(get()) }
    viewModel { MainViewModel(get()) }
}
