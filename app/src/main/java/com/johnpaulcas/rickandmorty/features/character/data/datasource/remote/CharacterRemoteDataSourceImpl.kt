package com.johnpaulcas.rickandmorty.features.character.data.datasource.remote

import com.johnpaulcas.rickandmorty.core.data.network.safeCall
import com.johnpaulcas.rickandmorty.core.domain.util.NetworkError
import com.johnpaulcas.rickandmorty.core.domain.util.Result
import com.johnpaulcas.rickandmorty.core.domain.util.map
import com.johnpaulcas.rickandmorty.features.character.data.datasource.remote.dto.CharacterDto
import com.johnpaulcas.rickandmorty.features.character.data.datasource.remote.dto.CharacterResponseDto
import com.johnpaulcas.rickandmorty.features.character.data.mapper.toDomain
import com.johnpaulcas.rickandmorty.features.character.domain.model.character.Character
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class CharacterRemoteDataSourceImpl(
    private val httpClient: HttpClient
): CharacterRemoteDataSource {
    override suspend fun getCharacters(): Result<List<Character>, NetworkError> {
        return safeCall<CharacterResponseDto> {
            httpClient.get(
                "/api/character"
            )
        }.map { response ->
            response.results.map { it.toDomain() }
        }
    }

    override suspend fun getCharacter(id: String): Result<Character, NetworkError> {
        return safeCall<CharacterDto> {
            httpClient.get("/character/$id")
        }.map { response ->
            response.toDomain()
        }
    }
}