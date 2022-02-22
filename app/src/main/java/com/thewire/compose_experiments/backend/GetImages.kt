package com.thewire.compose_experiments.backend

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.thewire.compose_experiments.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun getImages(): Flow<Int> = flow {
    emit(R.drawable.default_img)
    delay(5000)
    emit(R.drawable.starship)
}