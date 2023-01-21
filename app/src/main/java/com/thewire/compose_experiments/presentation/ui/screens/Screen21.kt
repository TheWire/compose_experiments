package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.core.graphics.PathParser
import kotlin.math.roundToInt

@Composable
fun Screen21() {
    Column(
        modifier = Modifier
            .background(Color.White)
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
        Box(
            modifier = Modifier
                .size(1000.dp)
                .clip(DirButton())
                .background(Color.Red)
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

            )
        }
    }
}

class DirButton: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
        ): Outline {
        val pathData = """M-0.3324315,-1.6103641 A1.7049222,1.7049222 188.6840468 0,0 1.6103641,0.3324315 
        A0.2,0.2 261.3159532 0,1 1.8405612,0.5301387 L1.8405612,1.3366422 A0.2,0.2 0 0,1 1.6618273,1.5355084 
        A2.9049222,2.9049222 83.896171 0,1 -1.5355084,-1.6618273 A0.2,0.2 186.103829 0,1 -1.3366422,-1.8405612 
        L-0.5301387,-1.8405612 A0.2,0.2 270 0,1 -0.3324315,-1.6103641z"""
        val scaleX = size.width/122.88F
        val scaleY = size.height/107.41F
        return Outline.Generic(PathParser.createPathFromPathData(pathData).asComposePath())
    }


}