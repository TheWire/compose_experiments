package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.thewire.compose_experiments.R

@Composable
fun Screen12() {
    AsyncImage(
        model = "https://picsum.photos/seed/picsum/200/300",
        placeholder = painterResource(R.drawable.starship),
        onLoading = { println("coli loading")},
        onError = { println("coil error")},
        contentScale = ContentScale.Crop,
        contentDescription = "test coil image",
    )
}