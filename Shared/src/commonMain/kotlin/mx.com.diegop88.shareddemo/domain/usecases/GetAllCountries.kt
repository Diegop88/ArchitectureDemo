package mx.com.diegop88.shareddemo.domain.usecases

import mx.com.diegop88.shareddemo.domain.repositories.DemoRepository

class GetAllCountries(private val demoRepository: DemoRepository) {
    suspend operator fun invoke() = demoRepository.getAllCountries()
}
