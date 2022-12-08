package com.thewire.compose_experiments.presentation.ui.experiemental15

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.thewire.compose_experiments.presentation.ui.experiemental15.ExperimentalViewModel15Event.*

class ExperimentalViewModel15 : ViewModel() {
    var videoSeconds by mutableStateOf(0f)
    var videoState by mutableStateOf("UNSTARTED")
    var lifeCycleState by mutableStateOf(false)

    fun onEvent(event: ExperimentalViewModel15Event) {
        when(event) {
            is OnSecondChange -> {
                videoSeconds = event.second
            }
            is OnStateChange -> {
                if(lifeCycleState) {
                    videoState = event.state
                }
            }
            is OnLifeCycleChange -> {
                lifeCycleState = event.lifecycleState
            }
        }
    }
}