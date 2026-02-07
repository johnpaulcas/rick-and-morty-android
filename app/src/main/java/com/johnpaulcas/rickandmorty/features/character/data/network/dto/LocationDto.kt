package com.johnpaulcas.rickandmorty.features.character.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    val name: String,
    val url: String
)