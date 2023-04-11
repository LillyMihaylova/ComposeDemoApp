package com.example.composedemoapp.di

import com.example.composedemoapp.viewmodel.LaunchesScreenVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { LaunchesScreenVM(get()) }
}