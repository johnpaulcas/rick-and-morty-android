package com.johnpaulcas.rickandmorty.features.character.domain.usecase

import com.johnpaulcas.rickandmorty.core.domain.util.NetworkError
import com.johnpaulcas.rickandmorty.core.domain.util.Result
import com.johnpaulcas.rickandmorty.features.character.domain.model.character.Character
import com.johnpaulcas.rickandmorty.features.character.domain.repository.CharacterRepository

class GetCharacterDetailUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: String): Result<Character, NetworkError> {
        return repository.getCharacter(id)
    }
}