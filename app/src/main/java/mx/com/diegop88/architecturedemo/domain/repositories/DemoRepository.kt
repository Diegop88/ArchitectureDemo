package mx.com.diegop88.architecturedemo.domain.repositories

import mx.com.diegop88.architecturedemo.data.DemoService
import mx.com.diegop88.architecturedemo.data.entities.Country
import mx.com.diegop88.architecturedemo.utils.Resource
import java.io.IOException

class DemoRepository(private val demoService: DemoService) {

    suspend fun getAllCountries(): Resource<List<Country>> {
        return try {
            val result = demoService.getAllCountries().await()
            if (result.isSuccessful) {
                val data = result.body()
                if (data != null) {
                    Resource.Success(data)
                } else {
                    Resource.Error(IOException("Data is null"))
                }
            } else {
                Resource.Error(IOException(result.message()))
            }
        } catch (exception: IOException) {
            Resource.Error(exception)
        }
    }
}
