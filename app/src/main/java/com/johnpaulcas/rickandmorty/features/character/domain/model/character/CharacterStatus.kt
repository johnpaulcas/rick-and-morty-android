package com.johnpaulcas.rickandmorty.features.character.domain.model.character

sealed class CharacterStatus(val status: String) {
    object Alive: CharacterStatus("Alive")
    object Dead: CharacterStatus("Dead")
    object Unknown: CharacterStatus("Unknown")
}