package mx.com.diegop88.shareddemo.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import mx.com.diegop88.shareddemo.data.entities.CountriesEntity

class DemoService(private val engine: HttpClientEngine) {

    private val client by lazy {
        HttpClient(engine) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }
    }

    suspend fun getAllCountries() = client.get<CountriesEntity> {
        url("$baseUrl/rest/v2/all?fields=name;capital")
    }

    companion object {
        private const val baseUrl = "https://restcountries.eu/"
    }
}
