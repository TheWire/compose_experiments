package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Screen22() {
    val enabled = remember { mutableStateOf(true) }
    val someText = remember { mutableStateOf("no text")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Button(
            onClick = { enabled.value = !enabled.value }
        ) {
            Text("enabled/disable")
        }
        TestButton(enabled= enabled.value, someText)
        Text(someText.value)
    }
}

@Composable
fun TestButton(enabled: Boolean, someText: MutableState<String>) {
    Button(
        onClick = {someText.value = "some text"}
    ) {
        Text(if(enabled) "enabled" else "disabled")
    }
}