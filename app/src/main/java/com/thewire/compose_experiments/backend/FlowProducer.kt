package com.thewire.compose_experiments.backend

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class FlowProducer {
    val flow: Flow<String> = flow {
        var a = 0
        while(true) {
            emit("this is flow $a")
            delay(2000)
            a++
        }
    }.flowOn(Dispatchers.IO)
}