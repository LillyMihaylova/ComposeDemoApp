package com.example.composedemoapp.network.util

import com.example.composedemoapp.network.throwable.HtmlResponseException
import com.example.composedemoapp.network.throwable.NetworkConnectivityException
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

suspend inline fun <T, reified E> safeApiCall(
    dispatcher: CoroutineDispatcher,
    crossinline apiCall: suspend () -> T
): ResultWrapper<T, E> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (exception: Exception) {
            when (exception) {
                is ResponseException -> {
                    val code = exception.response.status.value
                    val error: E = exception.response.body()
                    ResultWrapper.Error(code, error)
                }
                is HtmlResponseException -> { ResultWrapper.BotProtectionError }
                is NetworkConnectivityException -> ResultWrapper.NetworkError
                else -> ResultWrapper.Error()
            }
        }
    }
}

sealed class ResultWrapper<out T, out E> {
    data class Success<out T>(val value: T) : ResultWrapper<T, Nothing>()

    data class Error<out E>(
        val code: Int? = null,
        val error: E? = null
    ) : ResultWrapper<Nothing, E>()

    object BotProtectionError : ResultWrapper<Nothing, Nothing>()
    object NetworkError : ResultWrapper<Nothing, Nothing>()
}