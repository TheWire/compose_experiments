package com.thewire.compose_experiments.presentation.ui.experiemental15

sealed class ExperimentalViewModel15Event {
    data class OnSecondChange(val second: Float): ExperimentalViewModel15Event()
    data class OnStateChange(val state: String): ExperimentalViewModel15Event()
    data class OnLifeCycleChange(val lifecycleState: Boolean): ExperimentalViewModel15Event()
}