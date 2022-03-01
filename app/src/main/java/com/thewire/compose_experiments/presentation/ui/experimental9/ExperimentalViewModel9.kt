package com.thewire.compose_experiments.presentation.ui.experimental9

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel

class ExperimentalViewModel9 : ViewModel() {
    val map = mutableStateMapOf<String, String>()

    fun addKV(k: String, v: String) {
        map[k] = v
    }
}