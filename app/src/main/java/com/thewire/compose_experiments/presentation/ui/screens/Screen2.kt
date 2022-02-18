package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.thewire.compose_experiments.presentation.ui.experiment2.ExperimentalViewModel2
import com.thewire.compose_experiments.presentation.ui.experiment2.ExperimentalViewModel2Event

@Composable
fun Screen2(
    viewModel: ExperimentalViewModel2,
    navController: NavController
) {
    DisposableEffect(key1 = viewModel) {
        viewModel.onEvent(ExperimentalViewModel2Event.OnStart)
        onDispose { viewModel.onEvent(ExperimentalViewModel2Event.OnStop) }
    }
    Surface {
        Column {
            Text("Screen 2")
            val text = viewModel.myFlow.collectAsState("")
            Text(text.value)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "some text and some more text and even more text and even then more derp foo bar baz",
                     modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "delete"
                )
            }

            Button(
                onClick = {navController.popBackStack()}
            ) {
                Text("Back")
            }
        }

    }
}