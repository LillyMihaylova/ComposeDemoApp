package com.example.composedemoapp.network.usecase

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class NetworkMonitorUseCaseImpl(
    private val context: Context
) : NetworkMonitorUseCase {

    override fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        val activeNetwork = connectivityManager?.activeNetwork
        return connectivityManager?.getNetworkCapabilities(activeNetwork)?.let {
            it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    it.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ||
                    it.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH)
        } ?: false
    }
}