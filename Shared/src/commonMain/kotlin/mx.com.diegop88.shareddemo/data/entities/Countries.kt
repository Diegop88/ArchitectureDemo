package mx.com.diegop88.shareddemo.data.entities

import kotlinx.serialization.*

@Serializable
data class CountriesEntity(
    val countries: List<CountryEntity>
) {
    @Serializer(CountriesEntity::class)
    companion object : KSerializer<CountriesEntity> {
        override fun serialize(output: Encoder, obj: CountriesEntity) {
            CountryEntity.serializer().list.serialize(output, obj.countries)
        }

        override fun deserialize(input: Decoder): CountriesEntity =
            CountriesEntity(CountryEntity.serializer().list.deserialize(input))
    }
}
