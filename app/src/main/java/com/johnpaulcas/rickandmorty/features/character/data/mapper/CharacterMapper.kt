package com.johnpaulcas.rickandmorty.features.character.data.mapper

import com.johnpaulcas.rickandmorty.features.character.data.datasource.remote.dto.CharacterDto
import com.johnpaulcas.rickandmorty.features.character.data.datasource.remote.dto.LocationDto
import com.johnpaulcas.rickandmorty.features.character.data.datasource.remote.dto.OriginDto
import com.johnpaulcas.rickandmorty.features.character.domain.model.character.Character
import com.johnpaulcas.rickandmorty.features.character.domain.model.character.Character.Location
import com.johnpaulcas.rickandmorty.features.character.domain.model.character.Character.Origin
import com.johnpaulcas.rickandmorty.features.character.domain.model.character.CharacterStatus
import com.johnpaulcas.rickandmorty.features.character.domain.model.character.Gender
import java.time.Instant

fun CharacterDto.toDomain(): Character {
    return Character(
        id = id,
        createdAt = Instant.parse(created),
        episodeUrls = episode,
        imageUrl = image,
        name = name,
        species = species,
        type = type,
        status = status.toCharacterStatus(),
        gender = gender.toGender(),
        location = location.toDomain(),
        origin = origin.toDomain()
    )
}

fun LocationDto.toDomain() = Location(name, url)

fun OriginDto.toDomain() = Origin(name, url)

fun String.toCharacterStatus(): CharacterStatus =
    when (lowercase()) {
        "alive" -> CharacterStatus.Alive
        "dead" -> CharacterStatus.Dead
        else -> CharacterStatus.Unknown
    }

fun String.toGender(): Gender =
    when (lowercase()) {
        "male" -> Gender.Male
        "female" -> Gender.Female
        "genderless" -> Gender.GenderLess
        else -> Gender.Unknown
    }