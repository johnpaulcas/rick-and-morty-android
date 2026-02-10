package com.johnpaulcas.rickandmorty.di

import com.johnpaulcas.rickandmorty.features.character.data.datasource.remote.CharacterRemoteDataSource
import com.johnpaulcas.rickandmorty.features.character.data.datasource.remote.CharacterRemoteDataSourceImpl
import com.johnpaulcas.rickandmorty.features.character.data.repository.CharacterRepositoryImpl
import com.johnpaulcas.rickandmorty.features.character.domain.repository.CharacterRepository
import com.johnpaulcas.rickandmorty.features.character.domain.usecase.GetCharactersUseCase
import com.johnpaulcas.rickandmorty.features.character.presentation.list.CharacterListViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val characterModule = module {
    singleOf(::CharacterRemoteDataSourceImpl).bind<CharacterRemoteDataSource>()
    singleOf(::CharacterRepositoryImpl).bind<CharacterRepository>()

    factoryOf(::GetCharactersUseCase)
//    factoryOf(GetCh)

    viewModelOf(::CharacterListViewModel)
}
