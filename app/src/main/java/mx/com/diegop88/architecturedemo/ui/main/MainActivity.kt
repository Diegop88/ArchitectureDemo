package mx.com.diegop88.architecturedemo.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import mx.com.diegop88.architecturedemo.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    private val adapter = CountriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.countriesData.observe(this, Observer {
            refresh.isRefreshing = false
            adapter.submitList(it)
        })
        mainViewModel.errorData.observe(this, Observer {
            refresh.isRefreshing = false
            it.printStackTrace()
            Snackbar.make(countriesList, "Error $it.message", Snackbar.LENGTH_LONG).show()
        })

        refresh.setOnRefreshListener { mainViewModel.getCountries() }

        countriesList.layoutManager = LinearLayoutManager(this)
        countriesList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        countriesList.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.getCountries()
    }
}
