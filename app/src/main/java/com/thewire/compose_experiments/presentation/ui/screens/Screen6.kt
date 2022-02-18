package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.thewire.compose_experiments.presentation.ui.theme.Compose_experimentsTheme


@Composable
fun Screen6() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.LightGray
    ) {

    }
    Box(
        modifier = Modifier
    ) {
        Text(
            text = "Hi There",
            modifier = Modifier
                .padding(top = 24.dp)
                .firstBaselineTop(0.dp)
        )
    }
}

fun Modifier.firstBaselineTop(
    firstBaselineTop: Dp
) = layout { measurable: Measurable, constraints: Constraints ->
    val placeable = measurable.measure(constraints)

    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]
    val totalHeight = placeable.height + (firstBaselineTop.roundToPx() - firstBaseline)
    val placeableY = totalHeight - placeable.height
    layout(width = placeable.width, height = placeable.height){
        placeable.placeRelative(0, placeableY)
    }
}

@Preview
@Composable
fun Screen6Preview() {
    Compose_experimentsTheme {
        Screen6()
    }
}

