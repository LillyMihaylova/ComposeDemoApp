package com.example.composedemoapp.network

import com.example.composedemoapp.network.HttpClientDefinition.Companion.LAUNCHES_URL
import com.example.composedemoapp.network.model.response.Launch
import io.ktor.client.call.*
import io.ktor.client.request.*

class ApiDefinition(httpClientDefinition: HttpClientDefinition) {

    private val client = httpClientDefinition.getClient()

    suspend fun getLaunches(): List<Launch> {
        return client.get(LAUNCHES_URL).body()
    }
}