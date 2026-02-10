package com.johnpaulcas.rickandmorty.features.character.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnpaulcas.rickandmorty.core.domain.util.Result
import com.johnpaulcas.rickandmorty.features.character.domain.usecase.GetCharactersUseCase
import com.johnpaulcas.rickandmorty.features.character.presentation.model.toUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val getCharacter: GetCharactersUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(CharacterListUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadCharacters()
    }

    fun loadCharacters() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }

            when (val result = getCharacter()) {
                is Result.Ok -> {
                    _uiState.update { uiState ->
                        uiState.copy(
                            isLoading = false,
                            characters = result.data.map { it.toUi() }
                        )
                    }
                }
                is Result.Err -> {
                }
            }

        }
    }
}