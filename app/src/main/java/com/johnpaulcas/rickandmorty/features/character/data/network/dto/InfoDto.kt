package com.johnpaulcas.rickandmorty.features.character.data.network.dto

data class InfoDto(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)