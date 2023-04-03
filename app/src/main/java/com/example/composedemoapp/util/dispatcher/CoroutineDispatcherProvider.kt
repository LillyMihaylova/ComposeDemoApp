package com.example.composedemoapp.util.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val coroutineDispatcherProviderModule = module {
    single { CoroutineDispatcherProvider() }
}

open class CoroutineDispatcherProvider {
    open val main: CoroutineDispatcher = Dispatchers.Main
    open val io: CoroutineDispatcher = Dispatchers.IO
}