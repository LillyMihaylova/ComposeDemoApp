package com.example.composedemoapp.network.service

import com.example.composedemoapp.network.ApiDefinition
import com.example.composedemoapp.util.dispatcher.CoroutineDispatcherProvider

class ApiService(
    private val apiDefinition: ApiDefinition,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
) {


}