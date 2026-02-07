package com.johnpaulcas.rickandmorty.features.character.domain

import java.time.Instant

data class Character(
    val createdAt: Instant,
    val episodeUrls: List<String>,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val species: String,
    val type: String,
    val status: CharacterStatus,
    val gender: Gender,
    val location: Location,
    val origin: Origin
) {
    data class Location(
        val name: String,
        val url: String
    )

    data class Origin(
        val name: String,
        val url: String
    )
}