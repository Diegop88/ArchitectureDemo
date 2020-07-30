package mx.com.diegop88.architecturedemo.domain.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import mx.com.diegop88.architecturedemo.data.DemoService
import java.util.concurrent.TimeUnit

class DemoRepository(private val demoService: DemoService) {

    suspend fun getAllCountries() = withContext(Dispatchers.IO) {
        delay(TimeUnit.SECONDS.toMillis(3))
        demoService.getAllCountries()
    }
}
