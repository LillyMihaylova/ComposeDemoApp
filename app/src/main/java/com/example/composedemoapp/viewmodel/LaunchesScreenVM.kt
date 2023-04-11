package com.example.composedemoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemoapp.domain.usecase.GetLaunchesUseCase
import com.example.composedemoapp.domain.usecase.ResultUseCase
import kotlinx.coroutines.launch

class LaunchesScreenVM(private val getLaunchesUseCase: GetLaunchesUseCase) : ViewModel() {

    fun getLaunches() {
        viewModelScope.launch {
            when (val response = getLaunchesUseCase()) {
                is ResultUseCase.Success -> {}
                is ResultUseCase.Error -> {}
                is ResultUseCase.NetworkError -> {}
            }
        }
    }
}