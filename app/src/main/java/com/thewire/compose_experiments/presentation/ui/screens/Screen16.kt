package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Dialog
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Screen16() {
    var dialog by remember{ mutableStateOf(false)}
    if(dialog) {
        Dialog(
            onDismissRequest = {
                dialog = false
            }
        ) {
            Column() {
                Button(
                    onClick = { dialog = !dialog }
                ) {
                    Text(if (dialog) "dialog off" else "dialog on")
                }
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(color = Color.Magenta)
                )
            }
        }
    } else {
        Button(
            onClick = {dialog = !dialog}
        ) {
            Text(if(dialog) "dialog off" else "dialog on")
        }
    }
}