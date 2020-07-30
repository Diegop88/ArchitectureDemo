package mx.com.diegop88.architecturedemo.utils

sealed class Resource {
    object Loading : Resource()
    class Success(val requestCode: Int, val data: Any) : Resource() {
        inline fun <reified T> responseTo() = data as T
    }
    object Complete : Resource()
    class Error(val exception: Throwable) : Resource()
}
