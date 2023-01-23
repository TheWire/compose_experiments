package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.thewire.experimentallibrary.ExperimentalMath

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
        Cuber()
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

@Composable
fun Cuber() {
    Column() {
        val textState = remember { mutableStateOf("") }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it }
        )
        val experimentalMath = ExperimentalMath()
        Button(
            onClick = { textState.value = experimentalMath.cube(textState.value.toFloat()).toString()}
        ) {
            Text("cube")
        }
    }
}