package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

@Composable
fun Screen21() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        Text(
            text = "Draggable Text",
            modifier = Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt())}
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        offsetX += delta
                    }
                )
                .draggable(
                    orientation = Orientation.Vertical,
                    state = rememberDraggableState { delta ->
                        offsetY += delta
                    }
                )
        )
        var offsetX2 by remember { mutableStateOf(0f) }
        var offsetY2 by remember { mutableStateOf(0f) }
        Text(
            text = "Draggable Text Method 2",
            modifier = Modifier
                .offset { IntOffset(offsetX2.roundToInt(), offsetY2.roundToInt())}
                .pointerInput(Unit) {
                    detectDragGestures(onDragEnd = {
                        offsetX2 = 0f
                        offsetY2 = 0f
                    }) { change, dragAmount ->
                        change.consume()
                        offsetX2 += dragAmount.x
                        offsetY2 += dragAmount.y
                    }
                }
        )
        JoyStick(
            modifier = Modifier
                .size(150.dp)
                .padding(20.dp)
        )
    }

}

@Composable
fun JoyStick(modifier: Modifier =  Modifier) {
    Box(modifier = modifier) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .border(BorderStroke(1.dp, Color.Black), CircleShape)
        ) {
            val size = 40.dp
            var offsetX by remember { mutableStateOf(0f) }
            var offsetY by remember { mutableStateOf(0f) }
            val maxOffset = (with(LocalDensity.current) { maxHeight.toPx() - (size.toPx()) }) / 2
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                    .size(size)
                    .clip(CircleShape)
                    .background(Color.Black)
                    .pointerInput(Unit) {
                        detectDragGestures(onDragEnd = {
                            offsetX = 0f
                            offsetY = 0f
                        }) { change, dragAmount ->
                            change.consume()
                            val newX = offsetX + dragAmount.x
                            val newY = offsetY + dragAmount.y
                            val dist = sqrt(newX.pow(2) + newY.pow(2))
                            println(dist)
                            println(maxOffset)
                            if(dist <= maxOffset) {
                                offsetX = newX
                                offsetY = newY
                            }
                        }
                    }
            )
        }
    }
}