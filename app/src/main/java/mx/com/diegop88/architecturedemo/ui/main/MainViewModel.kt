package mx.com.diegop88.architecturedemo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mx.com.diegop88.architecturedemo.data.entities.Country
import mx.com.diegop88.architecturedemo.domain.usecases.GetAllCountries
import mx.com.diegop88.architecturedemo.utils.Resource

class MainViewModel(private val getAllCountries: GetAllCountries) : ViewModel() {

    private val _countriesData = MutableLiveData<List<Country>>()
    val countriesData: LiveData<List<Country>>
        get() = _countriesData

    private val _errorData = MutableLiveData<Exception>()
    val errorData: LiveData<Exception>
        get() = _errorData

    fun getCountries() = GlobalScope.launch {
        val result = getAllCountries()
        withContext(Dispatchers.Main) {
            when (result) {
                is Resource.Success -> _countriesData.value = result.data
                is Resource.Error -> _errorData.value = result.exception
            }
        }
    }
}
