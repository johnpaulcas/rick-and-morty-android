package com.johnpaulcas.rickandmorty.features.character.data.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class InfoDto(
    val count: Int,
    val next: String,
    val pages: Int,
)