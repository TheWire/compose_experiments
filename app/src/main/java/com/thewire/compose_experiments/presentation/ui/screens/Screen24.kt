package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Screen24() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val pagerState = rememberPagerState()
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .border(1.dp, Color.Magenta),
            pageCount = 10,
            state = pagerState
        ) { page ->
            Text(
                text = "Page: $page",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}