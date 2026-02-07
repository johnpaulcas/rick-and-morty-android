package com.johnpaulcas.rickandmorty.features.character.presentation.model

import androidx.compose.ui.graphics.Color
import com.johnpaulcas.rickandmorty.features.character.domain.Character
import com.johnpaulcas.rickandmorty.features.character.domain.CharacterStatus
import com.johnpaulcas.rickandmorty.features.character.domain.Gender
import com.johnpaulcas.rickandmorty.features.character.presentation.model.CharacterUi.Location
import com.johnpaulcas.rickandmorty.features.character.presentation.model.CharacterUi.Origin
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

data class CharacterUi(
    val createdAt: DisplayableDate,
    val episodeUrls: List<String>,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val species: String,
    val type: String,
    val status: DisplayableCharacterStatus,
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

data class DisplayableDate(
    val value: Instant,
    val formatted: String
)

data class DisplayableCharacterStatus(
    val value: String,
    val color: Color
)


fun Character.toUi(): CharacterUi {
    return CharacterUi(
        id = id,
        name = name,
        createdAt = createdAt.toDisplayableDate(),
        episodeUrls = episodeUrls,
        imageUrl = imageUrl,
        species = species,
        type = type,
        status = status.toDisplayableStatus(),
        gender = gender,
        location = Location(
            name = location.name,
            url = location.url
        ),
        origin = Origin(
            name = origin.name,
            url = origin.url
        )
    )
}

fun Instant.toDisplayableDate(): DisplayableDate {
    val formatter = DateTimeFormatter.ofPattern("MMM, dd yyyy")
        .withZone(ZoneId.systemDefault())
        .format(this)

    return DisplayableDate(
        value = this,
        formatted = formatter
    )
}

fun CharacterStatus.toDisplayableStatus(): DisplayableCharacterStatus {
    val color = when (this) {
        CharacterStatus.Alive -> Color.Green
        CharacterStatus.Dead -> Color.Red
        else -> Color.Gray
    }

    return DisplayableCharacterStatus(
        value = this.status,
        color = color
    )
}
