package com.thewire.compose_experiments.presentation.ui.components

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect

@Composable
fun OrientationLazy(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier,
    content: LazyListScope.(Modifier) -> Unit = {}
) {
    val configuration = LocalConfiguration.current
    val orientation = remember { mutableStateOf(ORIENTATION_PORTRAIT) }
    LaunchedEffect(configuration) {
        snapshotFlow { configuration.orientation }
            .collect { orientation.value = it }
    }

    when(orientation.value) {
        ORIENTATION_LANDSCAPE -> {
            LazyRow(
                modifier = modifier,
            ) {
                content(contentModifier.fillMaxHeight().widthIn(400.dp, 600.dp))
            }
        }
        ORIENTATION_PORTRAIT -> {
            LazyColumn(
                modifier = modifier,
            ) {
                content(contentModifier.fillMaxWidth().heightIn(300.dp, 400.dp))
            }
        }
    }
}


