package com.johnpaulcas.rickandmorty.features.character.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class InfoDto(
    val count: Int,
    val next: String,
    val pages: Int,
)