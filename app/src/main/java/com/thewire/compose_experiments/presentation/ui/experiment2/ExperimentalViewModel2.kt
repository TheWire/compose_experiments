package com.thewire.compose_experiments.presentation.ui.experiment2

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thewire.compose_experiments.backend.FlowProducer
import com.thewire.compose_experiments.backend.IntermediateFlow
import com.thewire.compose_experiments.presentation.ui.experimental1.ExperimentalViewModel1Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.random.Random

const val TAG = "EXPERIMENTAL2"

class ExperimentalViewModel2 : ViewModel() {

    val flowProducer = FlowProducer()
    val intermediateFlow =  IntermediateFlow(flowProducer)
    lateinit var myFlow: Flow<String>
    val myData = mutableStateOf("")
    fun onEvent(event: ExperimentalViewModel2Event) {
        when(event) {
            ExperimentalViewModel2Event.OnStart -> {
                Log.d(TAG, "OnStart")
            }
            ExperimentalViewModel2Event.OnStop -> {
                Log.d(TAG, "OnStop")
            }
        }
    }

    init {
//        viewModelScope.launch {
//            intermediateFlow.modifiedFLow.collect {
//                myData.value = it
//            }
//        }
//        myFlow = flowProducer.flow
        myFlow = intermediateFlow.modifiedFLow
    }


}
