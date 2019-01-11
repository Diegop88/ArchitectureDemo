package mx.com.diegop88.architecturedemo.data.entities

import com.google.gson.annotations.SerializedName

class Country(
    @SerializedName("name")
    val name: String,
    @SerializedName("capital")
    val capital: String
)
