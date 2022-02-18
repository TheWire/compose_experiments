package com.thewire.compose_experiments.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import com.thewire.compose_experiments.presentation.ui.experimental1.ExperimentalViewModel1Event
import kotlinx.coroutines.flow.StateFlow

@Composable
fun LiveDataExperiment(
    data: LiveData<Int>?, data2: Int?,
    data3: StateFlow<Int>?,
    startButtonText: String,
    stopButtonText: String,
    onStart: () -> Unit,
    onStop: () -> Unit,
    onReset: () -> Unit,
) {
    Column() {
        data?.let {
            LiveDataDisplayer(it, null, null)
        }
        data2?.let {
            LiveDataDisplayer(null, it, null)
        }
        data3?.let {
            LiveDataDisplayer(null, null, it)
        }
        Row() {
            Button(
                onClick = onStart
            ) {
                Text(text =  startButtonText)
            }
            Button(
                onClick = onStop
            ) {
                Text(text = stopButtonText)
            }
            Button(
                onClick = onReset
            ) {
                Text(text = "reset")
            }
        }


    }
}