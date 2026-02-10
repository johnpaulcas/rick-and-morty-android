package com.johnpaulcas.rickandmorty.features.character.presentation.list

import com.johnpaulcas.rickandmorty.features.character.presentation.model.CharacterUi

data class CharacterListUiState(
    val isLoading: Boolean = false,
    val characters: List<CharacterUi> = emptyList(),
)
