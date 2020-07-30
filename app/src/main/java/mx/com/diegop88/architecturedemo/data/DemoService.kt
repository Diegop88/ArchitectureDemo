package mx.com.diegop88.architecturedemo.data

import mx.com.diegop88.architecturedemo.data.entities.Country
import retrofit2.http.GET

interface DemoService {

    @GET(URL)
    suspend fun getAllCountries(): List<Country>

    companion object {
        const val URL = "rest/v2/all?fields=name;capital"
    }
}
