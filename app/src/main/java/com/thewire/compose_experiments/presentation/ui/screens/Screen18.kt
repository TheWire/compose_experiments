package com.thewire.compose_experiments.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun Screen18() {
    val configuration = LocalConfiguration.current
    Log.i("FULL_SCREEN", configuration.screenHeightDp.toString())
    val systemUiController: SystemUiController = rememberSystemUiController()
    LaunchedEffect(true) {
        systemUiController.isSystemBarsVisible = false
    }
    DisposableEffect(true) {
        onDispose {
            systemUiController.isSystemBarsVisible = true
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Magenta)
    ) {
        Box(
            modifier = Modifier
                .height(configuration.screenHeightDp.dp)
                .width(50.dp)
                .background(color = Color.Cyan)
        )
    }
}