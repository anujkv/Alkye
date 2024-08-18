package com.net.alkye.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import javax.inject.Inject

class NetworkUtil @Inject constructor(private val context: Context) {

    fun isNetworkAvailable(): Boolean{
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val capability = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        val isConnectedToInternet = capability?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            ?: false


        return isConnectedToInternet
    }
}