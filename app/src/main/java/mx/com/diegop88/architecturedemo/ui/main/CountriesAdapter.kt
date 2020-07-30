package mx.com.diegop88.architecturedemo.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_country.view.*
import mx.com.diegop88.architecturedemo.R
import mx.com.diegop88.architecturedemo.data.entities.Country

class CountriesAdapter : ListAdapter<Country, CountriesAdapter.CountryViewHolder>(Country.diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CountryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false))

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) = holder.bind(getItem(position))

    inner class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(country: Country?) {
            itemView.item_name.text = country?.name
            itemView.item_capital.text = country?.capital
        }
    }
}
