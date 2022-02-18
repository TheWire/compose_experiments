package com.thewire.compose_experiments.presentation.ui.experimental1

sealed class ExperimentalViewModel1Event {
    object OnStart: ExperimentalViewModel1Event()
    object OnStop: ExperimentalViewModel1Event()
    object OnChangeSomething: ExperimentalViewModel1Event()
    object OnContinuouslyChangeSomething: ExperimentalViewModel1Event()
    object OnContinuouslyChangeSomethingStop : ExperimentalViewModel1Event()
    object OnContinuouslyChangeSomethingReset : ExperimentalViewModel1Event() {

    }
}
