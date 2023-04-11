package com.example.composedemoapp.network.service

import com.example.composedemoapp.network.ApiDefinition
import com.example.composedemoapp.network.model.response.Launch
import com.example.composedemoapp.network.util.ResultWrapper
import com.example.composedemoapp.network.util.safeApiCall
import com.example.composedemoapp.util.dispatcher.CoroutineDispatcherProvider
import io.ktor.client.plugins.*

class ApiService(
    private val apiDefinition: ApiDefinition,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
) {

    suspend fun getLaunches(): ResultWrapper<List<Launch>, ResponseException> {
        return safeApiCall(coroutineDispatcherProvider.io) {
            apiDefinition.getLaunches()
        }
    }
}