package com.thewire.compose_experiments.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.StateFlow

@Composable
fun LiveDataDisplayer(liveData: LiveData<Int>?, data: Int?, stateFlow: StateFlow<Int>?) {
    Box() {
        val ret = liveData?.observeAsState() ?: (data ?: (stateFlow?.collectAsState()?.value ?: -1))
        val text = "data is $ret"
        println(text)
        Text(text = text)
    }
}