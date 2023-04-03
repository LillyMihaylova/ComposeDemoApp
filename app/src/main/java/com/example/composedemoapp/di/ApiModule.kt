package com.example.composedemoapp.di

import com.example.composedemoapp.network.ApiDefinition
import com.example.composedemoapp.network.HttpClientDefinition
import com.example.composedemoapp.network.service.ApiService
import com.example.composedemoapp.network.usecase.NetworkMonitorUseCase
import com.example.composedemoapp.network.usecase.NetworkMonitorUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val apiModule = module {
    single<NetworkMonitorUseCase> { NetworkMonitorUseCaseImpl(androidContext()) }
    single { HttpClientDefinition(get(), androidContext()) }
    single { ApiDefinition(get()) }
    single { ApiService(get(), get()) }
}