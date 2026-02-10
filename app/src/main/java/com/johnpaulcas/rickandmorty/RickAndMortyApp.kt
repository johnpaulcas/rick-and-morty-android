package com.johnpaulcas.rickandmorty

import android.app.Application
import com.johnpaulcas.rickandmorty.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RickAndMortyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RickAndMortyApp)
            androidLogger()

            modules(appModule)
        }
    }
}