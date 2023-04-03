package com.example.composedemoapp.network

import android.content.Context
import com.example.composedemoapp.network.interceptor.NetworkConnectivityInterceptor
import com.example.composedemoapp.network.throwable.HtmlResponseException
import com.example.composedemoapp.network.usecase.NetworkMonitorUseCase
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class HttpClientDefinition(
    private val networkMonitorUseCase: NetworkMonitorUseCase,
    private val context: Context
) {

    fun getClient(): HttpClient {
        val client = HttpClient(OkHttp) {
            defaultRequest {
                url(BASE_URL)
                url.protocol = URLProtocol.HTTPS
            }
            HttpResponseValidator {
                handleResponseExceptionWithRequest { exception, request ->
                    val clientException =
                        exception as? ClientRequestException
                            ?: return@handleResponseExceptionWithRequest
                    val exceptionResponse = clientException.response
                    val exceptionResponseText = exceptionResponse.bodyAsText()
                    if (exceptionResponse.status == HttpStatusCode.Forbidden
                        && exceptionResponseText.contains("<html")
                    ) {
                        throw HtmlResponseException()
                    }
                }
            }
            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }, contentType = ContentType.Any)
            }
            engine {
                addInterceptor(NetworkConnectivityInterceptor(networkMonitorUseCase))
            }
            expectSuccess = true

        }
        return client
    }

    companion object {
        const val BASE_URL = "https://api.spacexdata.com/v5/"
    }
}