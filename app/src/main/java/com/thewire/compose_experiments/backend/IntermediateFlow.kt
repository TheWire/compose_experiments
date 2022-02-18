package com.thewire.compose_experiments.backend

import kotlinx.coroutines.flow.*

class IntermediateFlow(private val flowProducer: FlowProducer) {
    val modifiedFLow: Flow<String> =
        flowProducer.flow.map {
            println("modifying")
            "$it modified"
        }
}