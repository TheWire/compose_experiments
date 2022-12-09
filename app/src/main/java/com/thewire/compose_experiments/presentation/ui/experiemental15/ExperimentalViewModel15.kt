package com.thewire.compose_experiments.presentation.ui.experiemental15

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.thewire.compose_experiments.presentation.ui.experiemental15.ExperimentalViewModel15Event.*

class ExperimentalViewModel15 : ViewModel(), DefaultLifecycleObserver {
    var videoSeconds by mutableStateOf(0f)
    var videoState by mutableStateOf("UNSTARTED")
    var lifeCycleState by mutableStateOf(false)

    override fun onStart(owner: LifecycleOwner) {
        Log.i("VIEW_MODEL_15", "START")

    }

    override fun onStop(owner: LifecycleOwner) {
        Log.i("VIEW_MODEL_15", "STOP")

    }

    override fun onPause(owner: LifecycleOwner) {
        Log.i("VIEW_MODEL_15", "PAUSE")
    }

    fun onEvent(event: ExperimentalViewModel15Event) {
        when(event) {
            is OnSecondChange -> {
                videoSeconds = event.second
            }
            is OnStateChange -> {
                videoState = event.state
            }
            is OnLifeCycleChange -> {
                lifeCycleState = event.lifecycleState
            }
        }
    }
}