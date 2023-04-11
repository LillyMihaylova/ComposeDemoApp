package com.example.composedemoapp.domain.usecase

import com.example.composedemoapp.network.model.response.Launches
import com.example.composedemoapp.network.service.ApiService
import com.example.composedemoapp.network.util.ResultWrapper
import io.ktor.client.plugins.*

class GetLaunchesUseCase(private val apiService: ApiService) {

    suspend operator fun invoke(): ResultUseCase<Launches, ResponseException> {
        return when (val response = apiService.getLaunches()) {
            is ResultWrapper.Success -> ResultUseCase.Success(response.value)
            is ResultWrapper.Error -> ResultUseCase.Error()
            is ResultWrapper.NetworkError -> ResultUseCase.NetworkError
        }
        return ResultUseCase.Error()
    }
}