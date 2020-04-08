package mx.com.diegop88.shareddemo.domain.usecases

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import mx.com.diegop88.shareddemo.domain.repositories.DemoRepository
import mx.com.diegop88.shareddemo.domain.usecases.models.Country
import mx.com.diegop88.shareddemo.utils.Resource

class GetAllCountries(private val demoRepository: DemoRepository) {
    suspend operator fun invoke() = demoRepository.getAllCountries()

    fun getAllCountries(callback: (Resource<List<Country>>) -> Unit) = GlobalScope.launch {
        val response = demoRepository.getAllCountries()
        callback(response)
    }
}
