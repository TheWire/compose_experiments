package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Screen13() {


    val refreshScope = rememberCoroutineScope()

    var refreshing by remember { mutableStateOf(false)}
    var refreshed by remember { mutableStateOf(false)}
    var itemCount by remember { mutableStateOf(15)}

    fun onRefresh() = refreshScope.launch {
        refreshing = true
        println("fresh")
        delay(1000)
        println("refreshing done")
        refreshed = true
        itemCount += 1
        refreshing = false
    }

    val state = rememberPullRefreshState(refreshing, ::onRefresh)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(state)
            .background(color = if (refreshing) Color.Blue else if (refreshed) Color.Magenta else Color.Green)
    ) {
        Column() {
            Button(onClick = { refreshing = !refreshing}) {
                Text(text = "Refreshing")
            }
            LazyColumn(Modifier.fillMaxSize()) {
                items(itemCount) {
                    ListItem { Text(text = "Item ${itemCount - it}")}
                }
            }
        }
        
        PullRefreshIndicator(
            refreshing = refreshing,
            state = state,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}
