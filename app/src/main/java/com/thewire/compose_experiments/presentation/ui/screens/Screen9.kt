package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Screen9() {
    BoxWithConstraints {
        val boxWidth = maxWidth
        val boxHeight = maxHeight / 2
        Column {
            Box(
                Modifier.size(boxWidth, boxHeight)
                .background(color = Color.Magenta),
            )
            Box(
                Modifier
                    .size(boxWidth, boxHeight)
                .background(color = Color.Cyan),
            )
        }
    }
}
