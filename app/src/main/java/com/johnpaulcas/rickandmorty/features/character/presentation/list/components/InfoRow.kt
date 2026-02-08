package com.johnpaulcas.rickandmorty.features.character.presentation.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.johnpaulcas.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun InfoRow(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = modifier.padding(8.dp)
        ) {
            Text(
                text = title,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = value,
                fontSize = 16.sp,
            )
        }
    }
}

@Composable
@PreviewLightDark
fun InfoRowPreview() {
    RickAndMortyTheme {
        InfoRow(
            title = "Last known location:",
            value = "Signus 5 Expanse",
            modifier = Modifier.background(
                color = MaterialTheme.colorScheme.background
            )
        )
    }
}