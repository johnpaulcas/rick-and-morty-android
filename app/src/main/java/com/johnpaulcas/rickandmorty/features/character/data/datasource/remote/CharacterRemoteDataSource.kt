package com.johnpaulcas.rickandmorty.features.character.data.datasource.remote

import com.johnpaulcas.rickandmorty.core.domain.util.NetworkError
import com.johnpaulcas.rickandmorty.core.domain.util.Result
import com.johnpaulcas.rickandmorty.features.character.domain.model.character.Character
import io.ktor.client.HttpClient

interface CharacterRemoteDataSource {
    suspend fun getCharacters(): Result<List<Character>, NetworkError>
    suspend fun getCharacter(id: String): Result<Character, NetworkError>
}