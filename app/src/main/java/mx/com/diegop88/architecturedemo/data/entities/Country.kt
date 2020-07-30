package mx.com.diegop88.architecturedemo.data.entities

import androidx.recyclerview.widget.DiffUtil

data class Country(
    val name: String,
    val capital: String
) {
    companion object {
        val diff = object : DiffUtil.ItemCallback<Country>() {
            override fun areItemsTheSame(oldItem: Country, newItem: Country) = oldItem.name == newItem.name
            override fun areContentsTheSame(oldItem: Country, newItem: Country) = oldItem == newItem
        }
    }
}
