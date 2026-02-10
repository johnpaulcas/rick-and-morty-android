package com.johnpaulcas.rickandmorty.features.character.domain.usecase

import com.johnpaulcas.rickandmorty.core.domain.util.NetworkError
import com.johnpaulcas.rickandmorty.core.domain.util.Result
import com.johnpaulcas.rickandmorty.features.character.domain.model.character.Character
import com.johnpaulcas.rickandmorty.features.character.domain.repository.CharacterRepository

class GetCharactersUseCase(
    private val repository: CharacterRepository
) {

    suspend operator fun invoke(): Result<List<Character>, NetworkError> {
        return repository.getCharacters()
    }

}