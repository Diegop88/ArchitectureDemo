package mx.com.diegop88.shareddemo.data

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.com.diegop88.shareddemo.data.entities.CountryEntity

class DemoService {

    private val client by lazy {
        HttpClient {
            install(JsonFeature)
        }
    }

    suspend fun getAllCountries() = withContext(Dispatchers.Default) {
        client.get<List<CountryEntity>> {
            url("$baseUrl/rest/v2/all?fields=name;capital")
        }
    }

    companion object {
        private const val baseUrl = "https://restcountries.eu/"
    }
}
