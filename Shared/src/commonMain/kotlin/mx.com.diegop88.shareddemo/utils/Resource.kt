package mx.com.diegop88.shareddemo.utils

sealed class Resource<out T : Any> {
    class Success<out T : Any>(val data: T) : Resource<T>()
    class Error(val exception: Exception) : Resource<Nothing>()
}
