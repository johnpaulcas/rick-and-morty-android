package com.johnpaulcas.rickandmorty.features.character.domain

sealed class CharacterStatus(val status: String) {
    object Alive: CharacterStatus("Alive")
    object Dead: CharacterStatus("Dead")
    object Unknown: CharacterStatus("Unknown")
}