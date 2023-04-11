package com.example.composedemoapp.di

import com.example.composedemoapp.domain.usecase.GetLaunchesUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { GetLaunchesUseCase(get()) }
}