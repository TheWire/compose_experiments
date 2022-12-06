package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Screen18() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(color = Color.DarkGray)
    ) {
        Column(
            modifier = Modifier
//                .height(IntrinsicSize.Min)
                .background(color = Color.Magenta)
        ) {
            Text("text at top")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = Color.Green)
            ){}
            Text("text at bottom")

        }
    }

}