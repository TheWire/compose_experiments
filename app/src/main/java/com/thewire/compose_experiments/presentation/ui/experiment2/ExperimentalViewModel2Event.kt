package com.thewire.compose_experiments.presentation.ui.experiment2

sealed class ExperimentalViewModel2Event {
    object OnStart: ExperimentalViewModel2Event()
    object OnStop: ExperimentalViewModel2Event()
}
