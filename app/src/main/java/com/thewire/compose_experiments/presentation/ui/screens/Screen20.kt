package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import kotlinx.coroutines.*

@Composable
fun Screen20() {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scope = rememberCoroutineScope()
    var job: Job? = null
    if(isPressed) {
        LaunchedEffect(Unit) {
            job = scope.launch(Dispatchers.IO) {
                var i = 0
                while(true) {
                    println("hello $i")
                    i++
                    delay(1000)
                }
            }
        }
        DisposableEffect(Unit) {
            onDispose {
                job?.cancel()
            }
        }
    }
    Column() {
        Button(
            onClick = {},
            interactionSource = interactionSource

        ) {
            Text(if(isPressed) "Release" else "Hold")
        }
    }
}