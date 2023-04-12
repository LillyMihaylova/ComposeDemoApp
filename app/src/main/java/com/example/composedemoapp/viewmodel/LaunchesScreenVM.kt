package com.example.composedemoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemoapp.domain.usecase.GetLaunchesUseCase
import com.example.composedemoapp.domain.usecase.ResultUseCase
import com.example.composedemoapp.network.model.response.Launch
import kotlinx.coroutines.launch

class LaunchesScreenVM(private val getLaunchesUseCase: GetLaunchesUseCase) : ViewModel() {

    var launches: MutableLiveData<List<Launch>?> = MutableLiveData()

    fun getLaunches() {
        viewModelScope.launch {
            when (val response = getLaunchesUseCase()) {
                is ResultUseCase.Success -> {
                    launches.value = response.data
                }
                is ResultUseCase.Error -> {}
                is ResultUseCase.NetworkError -> {}
            }
        }
    }
}