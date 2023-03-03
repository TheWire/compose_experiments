package com.thewire.compose_experiments.presentation.ui.experimental23

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ExperimentalViewModel23 : ViewModel() {
    var id = -1
    var someVal by mutableStateOf(0)
    init {
        println("constructor viewModel23 $id")
    }
}