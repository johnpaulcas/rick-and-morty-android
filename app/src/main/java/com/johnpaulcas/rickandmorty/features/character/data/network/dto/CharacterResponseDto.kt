package com.johnpaulcas.rickandmorty.features.character.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponseDto(
    val info: InfoDto,
    val results: List<CharacterDto>
)