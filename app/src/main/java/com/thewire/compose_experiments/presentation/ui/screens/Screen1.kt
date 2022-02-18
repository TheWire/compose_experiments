package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.thewire.compose_experiments.presentation.ui.components.LiveDataDisplayer
import com.thewire.compose_experiments.presentation.ui.components.LiveDataExperiment
import com.thewire.compose_experiments.presentation.ui.components.StopWatch
import com.thewire.compose_experiments.presentation.ui.experimental1.ExperimentalViewModel1
import com.thewire.compose_experiments.presentation.ui.experimental1.ExperimentalViewModel1Event

@Composable
fun Screen1(viewModel: ExperimentalViewModel1, navController: NavController) {
    DisposableEffect(key1 = viewModel) {
        viewModel.onEvent(ExperimentalViewModel1Event.OnStart)
        onDispose { viewModel.onEvent(ExperimentalViewModel1Event.OnStop) }
    }
    Surface{
        Column() {
//            LiveDataExperiment(viewModel.something, null, null,"Change Something") {
//                viewModel.onEvent(ExperimentalViewModel1Event.OnChangeSomething)
//            }
//            LiveDataExperiment(viewModel.constantlyChanging, null,null, "Change Something Continuously") {
//                viewModel.onEvent(ExperimentalViewModel1Event.OnContinuouslyChangeSomething)
//            }
            LiveDataExperiment(null,
                viewModel.constantlyChanging3.value,
                null,
                "Start",
                "Stop",
                { viewModel.onEvent(ExperimentalViewModel1Event.OnContinuouslyChangeSomething) },
                { viewModel.onEvent(ExperimentalViewModel1Event.OnContinuouslyChangeSomethingStop) },
                { viewModel.onEvent(ExperimentalViewModel1Event.OnContinuouslyChangeSomethingReset) }
            )
//            LiveDataExperiment(null, null , viewModel.constantlyChanging2, "Change Something Continuously") {
//                viewModel.onEvent(ExperimentalViewModel1Event.OnContinuouslyChangeSomething)
//            }
            StopWatch()
            Text(viewModel.time.value.toString())
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(200.dp)
                    .height(50.dp)
                    .background(color = Color.Magenta),
            ){}
        }
    }
}