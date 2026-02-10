package com.johnpaulcas.rickandmorty.features.character.data.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    val name: String,
    val url: String
)