package com.thewire.compose_experiments.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun StopWatch() {
    val job = remember { mutableStateOf<Job?>(null) }
    val time = remember { mutableStateOf(0)}
    val lifecycle =  LocalLifecycleOwner.current
    Column {
        Text(time.value.toString())
        Row {
            Button(onClick = {
                job.value = lifecycle.lifecycleScope.launch {
                    while(true) {
                        delay(1000)
                        time.value++
                        println(time.value)
                    }
                }
            }
            ) {
              Text("Start")
            }
            Button(onClick = { job.value?.cancel() }) {
                Text("Stop")
            }
            Button(onClick = { time.value = 0 }) {
                Text("Reset")
            }
        }
    }
}