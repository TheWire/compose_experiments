package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.thewire.compose_experiments.presentation.ui.experimental9.ExperimentalViewModel9

@Composable
fun Screen9(
    viewModel: ExperimentalViewModel9
) {
    Column() {
        Column() {
            val key = remember { mutableStateOf("")}
            val value = remember { mutableStateOf("")}
            TextField(
                value = key.value,
                onValueChange = {  key.value = it },
                label = { Text("Key") }
            )
            TextField(
                value = value.value,
                onValueChange = {  value.value = it },
                label = { Text("Value") }
            )
            Button(
                onClick = {
                    viewModel.addKV(key.value, value.value)
                    viewModel.map.forEach {
                        println("${it.key} ${it.value}")
                    }
                }
            ) {
                Text("Add")
            }
        }
        Column() {
            viewModel.map.forEach {
                Text(text = it.value)
            }
        }
    }

}
