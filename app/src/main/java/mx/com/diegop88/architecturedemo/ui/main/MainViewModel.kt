package mx.com.diegop88.architecturedemo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import mx.com.diegop88.architecturedemo.domain.usecases.GetAllCountries
import mx.com.diegop88.architecturedemo.utils.Resource

class MainViewModel(private val getAllCountries: GetAllCountries) : ViewModel() {

    private val _countriesData = MutableLiveData<Resource>()
    val countriesData: LiveData<Resource>
        get() = _countriesData

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _countriesData.postValue(Resource.Error(throwable))
    }

    fun getCountries() = CoroutineScope(handler).launch {
        _countriesData.postValue(Resource.Loading)

        val result = getAllCountries()
        _countriesData.postValue(result)
    }
}
