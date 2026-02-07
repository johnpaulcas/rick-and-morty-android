package com.johnpaulcas.rickandmorty.features.character.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)