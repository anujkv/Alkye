package com.net.alkye.utils.network

sealed class NetworkResource<T> (
    val data: T? = null,
    val message: String? = null) {

    class Success<T> (data: T?) : NetworkResource<T>(data)
    class Error<T> (message: String, data: T? = null) : NetworkResource<T>(data, message)
    class Loading<T> (val isLoading: Boolean = true): NetworkResource<T>()

}