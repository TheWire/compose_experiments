package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.thewire.compose_experiments.R

@Composable
fun Screen25() {
    Column(modifier = Modifier.fillMaxSize()) {
        WebCard()
    }
}

@Composable
fun WebCard() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.michael_dam_mez3pofgs_k_unsplash),
            contentDescription = "test image"
        )
        Text("Founder And Thinker")
        Text("Jack Mane")
        Row() {

        }
    }
}