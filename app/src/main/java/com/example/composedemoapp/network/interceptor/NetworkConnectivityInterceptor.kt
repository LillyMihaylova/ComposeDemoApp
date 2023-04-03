package com.example.composedemoapp.network.interceptor

import com.example.composedemoapp.network.throwable.NetworkConnectivityException
import com.example.composedemoapp.network.usecase.NetworkMonitorUseCase
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectivityInterceptor(
    private val networkMonitor: NetworkMonitorUseCase
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (networkMonitor.isConnected()) {
            return chain.proceed(chain.request())
        } else {
            throw NetworkConnectivityException()
        }
    }
}