package com.johnpaulcas.rickandmorty.features.character.presentation.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CharacterListScreen(
    state: CharacterListUiState,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    if (state.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Box(
            modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
        ) {
            CharacterList(
                characters = state.characters,
                onClick = onClick
            )
        }
    }
}