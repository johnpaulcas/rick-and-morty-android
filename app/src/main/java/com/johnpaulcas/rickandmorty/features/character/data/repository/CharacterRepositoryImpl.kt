package com.johnpaulcas.rickandmorty.features.character.data.repository

import com.johnpaulcas.rickandmorty.core.domain.util.NetworkError
import com.johnpaulcas.rickandmorty.core.domain.util.Result
import com.johnpaulcas.rickandmorty.features.character.data.datasource.remote.CharacterRemoteDataSource
import com.johnpaulcas.rickandmorty.features.character.domain.model.character.Character
import com.johnpaulcas.rickandmorty.features.character.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val dataSource: CharacterRemoteDataSource
) : CharacterRepository {

    override suspend fun getCharacters(): Result<List<Character>, NetworkError> = dataSource.getCharacters()

    override suspend fun getCharacter(id: String): Result<Character, NetworkError> = dataSource.getCharacter(id)
}