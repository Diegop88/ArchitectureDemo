package mx.com.diegop88.architecturedemo.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import mx.com.diegop88.architecturedemo.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainViewModel.Factory
    private lateinit var viewModel: MainViewModel

    private val adapter = CountriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        viewModel.countriesData.observe(this, Observer {
            refresh.isRefreshing = false
            adapter.submitList(it)
        })
        viewModel.errorData.observe(this, Observer {
            refresh.isRefreshing = false
            it.printStackTrace()
            Snackbar.make(countriesList, "Error $it.message", Snackbar.LENGTH_LONG).show()
        })

        refresh.setOnRefreshListener { viewModel.getCountries() }

        countriesList.layoutManager = LinearLayoutManager(this)
        countriesList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        countriesList.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.getCountries()
    }
}
