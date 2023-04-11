package com.example.composedemoapp.domain.usecase

sealed class ResultUseCase<out T, out E> {
    data class Success<out T>(val data: T) : ResultUseCase<T, Nothing>()

    object NetworkError : ResultUseCase<Nothing, Nothing>()

    data class Error<out E>(
        val code: Int? = null,
        val error: E? = null
    ) : ResultUseCase<Nothing, E>()
}