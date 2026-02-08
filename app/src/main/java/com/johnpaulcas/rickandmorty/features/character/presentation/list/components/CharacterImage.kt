package com.johnpaulcas.rickandmorty.features.character.presentation.list.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.johnpaulcas.rickandmorty.R
import com.johnpaulcas.rickandmorty.core.presentation.ui.preview.PreviewAsyncImage
import com.johnpaulcas.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun CharacterImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop,
        placeholder = painterResource(R.drawable.ic_launcher_background)
    )
}

@Composable
@Preview
fun CharacterImagePreview() {
    PreviewAsyncImage {
        RickAndMortyTheme {
            CharacterImage(
                imageUrl = "image url",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
        }
    }
}
