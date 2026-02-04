package com.johnpaulcas.rickandmorty.features.character.data.network.dto

data class CharacterResponseDto(
    val info: InfoDto,
    val results: List<CharacterDto>
)