package mx.com.diegop88.architecturedemo.domain.usecases

import mx.com.diegop88.architecturedemo.domain.repositories.DemoRepository
import mx.com.diegop88.architecturedemo.utils.RequestCodes
import mx.com.diegop88.architecturedemo.utils.Resource

class GetAllCountries(private val demoRepository: DemoRepository) {
    suspend operator fun invoke() = Resource.Success(RequestCodes.COUNTRIES, demoRepository.getAllCountries())
}
