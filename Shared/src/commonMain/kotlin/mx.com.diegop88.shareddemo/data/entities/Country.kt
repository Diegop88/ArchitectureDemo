package mx.com.diegop88.shareddemo.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class CountryEntity(val name: String, val capital: String)
