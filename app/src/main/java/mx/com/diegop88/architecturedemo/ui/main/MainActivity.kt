package mx.com.diegop88.architecturedemo.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import mx.com.diegop88.architecturedemo.R
import mx.com.diegop88.architecturedemo.data.entities.Country
import mx.com.diegop88.architecturedemo.utils.RequestCodes
import mx.com.diegop88.architecturedemo.utils.Resource
import org.koin.androidx.scope.lifecycleScope

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val mainViewModel: MainViewModel by lifecycleScope.inject()
    private val adapter = CountriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.countriesData.observe(this, Observer {
            when (it) {
                is Resource.Loading -> showLoading()
                is Resource.Success -> handleResponse(it)
                is Resource.Error -> showError(it.exception)
            }
        })

        refresh.setOnRefreshListener { mainViewModel.getCountries() }

        countriesList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        countriesList.adapter = adapter
    }

    private fun showLoading() {
        Snackbar.make(countriesList, "Loading", Snackbar.LENGTH_LONG).show()
    }

    private fun handleResponse(response: Resource.Success) {
        when (response.requestCode) {
            RequestCodes.COUNTRIES -> showCountries(response.responseTo())
        }
    }

    private fun showCountries(countries: List<Country>) {
        adapter.submitList(countries)
    }

    private fun showError(throwable: Throwable) {
        throwable.printStackTrace()
        Snackbar.make(countriesList, "Error: ${throwable.message}", Snackbar.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.getCountries()
    }
}
