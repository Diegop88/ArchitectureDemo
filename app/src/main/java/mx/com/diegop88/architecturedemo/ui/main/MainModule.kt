package mx.com.diegop88.architecturedemo.ui.main

import dagger.Module
import dagger.Provides
import mx.com.diegop88.architecturedemo.domain.repositories.DemoRepository
import mx.com.diegop88.architecturedemo.domain.usecases.GetAllCountries

@Module
class MainModule {
    @Provides
    fun provideGetAllCountries(demoRepository: DemoRepository) = GetAllCountries(demoRepository)

    @Provides
    fun provideFactory(getAllCountries: GetAllCountries) = MainViewModel.Factory(getAllCountries)
}
