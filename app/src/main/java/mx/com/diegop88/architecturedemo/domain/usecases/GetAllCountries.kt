package mx.com.diegop88.architecturedemo.domain.usecases

import mx.com.diegop88.architecturedemo.domain.repositories.DemoRepository

class GetAllCountries(private val demoRepository: DemoRepository) {
    suspend operator fun invoke() = demoRepository.getAllCountries()
}
