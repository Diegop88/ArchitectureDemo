package mx.com.diegop88.architecturedemo.data

import kotlinx.coroutines.Deferred
import mx.com.diegop88.architecturedemo.data.entities.Country
import retrofit2.Response
import retrofit2.http.GET

interface DemoService {

    @GET(URL)
    fun getAllCountries(): Deferred<Response<List<Country>>>

    companion object {
        const val URL = "rest/v2/all?fields=name;capital"
    }
}
