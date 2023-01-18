package com.thewire.compose_experiments.presentation.ui.screens

import android.util.Log
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import com.thewire.compose_experiments.presentation.ui.experimental19.ExperimentalViewModel19

private const val TAG = "SCREEN19"
@Composable
fun Screen19(viewModel: ExperimentalViewModel19) {
    LaunchedEffect(key1 = viewModel.someVal.value) {
        Log.i(TAG, "LaunchedEffect")
    }
    DisposableEffect(key1 = viewModel) {
        Log.i(TAG, "DisposableEffect")
        onDispose {
            Log.i(TAG, "onDispose")
        }
    }
    SideEffect {
        Log.i(TAG, "SideEffect")
    }

    Button(
        onClick = {viewModel.someVal.value = viewModel.someVal.value + 1}
    ) {
        Text("change state")
    }
}
