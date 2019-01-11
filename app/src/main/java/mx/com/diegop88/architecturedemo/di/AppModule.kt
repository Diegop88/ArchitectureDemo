package mx.com.diegop88.architecturedemo.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import mx.com.diegop88.architecturedemo.data.DemoService
import mx.com.diegop88.architecturedemo.domain.repositories.DemoRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideDemoService(): DemoService {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(BASE)
            .client(client)
            .build()
            .create(DemoService::class.java)
    }

    @Singleton
    @Provides
    fun provideDemoRepository(demoService: DemoService) = DemoRepository(demoService)

    companion object {
        const val BASE = "https://restcountries.eu/"
    }
}
