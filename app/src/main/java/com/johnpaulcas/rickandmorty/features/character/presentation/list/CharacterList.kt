package com.johnpaulcas.rickandmorty.features.character.presentation.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.johnpaulcas.rickandmorty.core.presentation.ui.preview.PreviewAsyncImage
import com.johnpaulcas.rickandmorty.features.character.presentation.list.components.CharacterItem
import com.johnpaulcas.rickandmorty.features.character.presentation.list.components.previewCharacterUi
import com.johnpaulcas.rickandmorty.features.character.presentation.model.CharacterUi
import com.johnpaulcas.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun CharacterList(
    characters: List<CharacterUi>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(characters) { characterUi ->
            CharacterItem(
                characterUi = characterUi
            )
        }
    }
}

@PreviewLightDark
@Composable
fun CharacterListPreview() {
    PreviewAsyncImage {
        RickAndMortyTheme {
            CharacterList(
                characters = previewCharacters,
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}

val previewCharacters = (1..10).map {
    previewCharacterUi
}