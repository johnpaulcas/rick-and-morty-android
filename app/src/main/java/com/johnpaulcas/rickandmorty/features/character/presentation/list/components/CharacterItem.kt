package com.johnpaulcas.rickandmorty.features.character.presentation.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ColorImage
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler
import com.johnpaulcas.rickandmorty.R
import com.johnpaulcas.rickandmorty.core.presentation.ui.preview.PreviewAsyncImage
import com.johnpaulcas.rickandmorty.features.character.domain.model.character.Gender
import com.johnpaulcas.rickandmorty.features.character.presentation.model.CharacterUi
import com.johnpaulcas.rickandmorty.features.character.presentation.model.DisplayableCharacterStatus
import com.johnpaulcas.rickandmorty.features.character.presentation.model.DisplayableDate
import com.johnpaulcas.rickandmorty.ui.theme.RickAndMortyTheme
import java.time.Instant

@Composable
fun CharacterItem(
    characterUi: CharacterUi,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    val radius = 16.dp
    Surface(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(radius),
        tonalElevation = 1.dp,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(characterUi.id) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CharacterImage(
                imageUrl = characterUi.imageUrl,
                modifier = Modifier
                    .weight(0.5f)
                    .height(210.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = radius,
                            bottomStart = radius
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .weight(0.6f)
                    .padding(top = 8.dp)
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = characterUi.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 4.dp,
                                bottom = 4.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .clip(CircleShape)
                                .background(characterUi.status.color)
                        )

                        Text(
                            text = "${characterUi.status.value} - ${characterUi.species}",
                            modifier = Modifier.padding(start = 8.dp),
                            fontWeight = FontWeight.Medium
                        )

                    }
                }

                InfoRow(
                    title = stringResource(R.string.title_last_known_location),
                    value = characterUi.location.name
                )

                InfoRow(
                    title = stringResource(R.string.title_first_seen_in),
                    value = characterUi.origin.name
                )

            }
        }
    }
}

@PreviewLightDark
@Composable
fun CharacterItemPreview() {
    PreviewAsyncImage {
        RickAndMortyTheme {
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    CharacterItem(
                        characterUi = previewCharacterUi,
                        onClick = {}
                    )
                }

            }
        }
    }
}

internal val previewCharacterUi = CharacterUi(
    id = 1,
    name = "Rick Sanchez",
    species = "Human",
    type = "",
    gender = Gender.Male,
    imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
    episodeUrls = listOf(
        "https://rickandmortyapi.com/api/episode/1",
        "https://rickandmortyapi.com/api/episode/2",
        "https://rickandmortyapi.com/api/episode/3"
    ),
    createdAt = DisplayableDate(
        value = Instant.parse("2017-11-04T18:48:46.250Z"),
        formatted = "Nov 04, 2017"
    ),
    status = DisplayableCharacterStatus(
        value = "Alive",
        color = Color.Green
    ),
    origin = CharacterUi.Origin(
        name = "Earth (C-137)",
        url = "https://rickandmortyapi.com/api/location/1"
    ),
    location = CharacterUi.Location(
        name = "Citadel of Ricks",
        url = "https://rickandmortyapi.com/api/location/3"
    )
)