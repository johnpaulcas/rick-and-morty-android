package com.johnpaulcas.rickandmorty.di

import com.johnpaulcas.rickandmorty.core.data.network.HttpClientFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module

val networkModule = module {
    single<HttpClient> { HttpClientFactory.create(CIO.create()) }
}