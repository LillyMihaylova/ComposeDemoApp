package com.example.composedemoapp

import android.app.Application
import com.example.composedemoapp.di.apiModule
import com.example.composedemoapp.di.repositoryModule
import com.example.composedemoapp.di.viewModelModule
import com.example.composedemoapp.util.dispatcher.coroutineDispatcherProviderModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        instance = this

        koinInit()
    }

    private fun koinInit() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(
                coroutineDispatcherProviderModule,
                apiModule,
                repositoryModule,
                viewModelModule
            )
        }
    }

    companion object {
        lateinit var instance: App
    }
}