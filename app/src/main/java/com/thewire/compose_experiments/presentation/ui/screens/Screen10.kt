package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.thewire.compose_experiments.R

@Composable
fun Screen10() {
    BoxWithConstraints {
        Column() {
            TestComposable(Color.Cyan, Color.Yellow, Color.Magenta)
            TestComposable(Color.Blue, Color.Green, Color.Red)
        }
        println("box $minWidth $maxWidth $minHeight $maxHeight")
    }

}

@Composable
fun TestComposable(color1: Color, color2: Color, color3: Color) {
    Card(
        modifier = Modifier,
        backgroundColor = color1
    ){
        ExperimentLayout(
            modifier = Modifier
                .background(color = color2)
        ) {
            Image(
                modifier = Modifier
                    .background(color = Color.Red),
                painter = painterResource(R.drawable.starship),
                contentDescription = ""
            )
        }
    }
}

@Composable
fun ExperimentLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        printConstraints("layout constraints", constraints)
        val imageConstraints = constraints.copy(
            minWidth = 0,
            maxWidth = 1000,
            minHeight = 0,
            maxHeight = 1000,
        )
        val place1 = measurables[0].measure(imageConstraints)
        println("place1 ${place1.width} ${place1.height}")
        val res = layout(constraints.maxWidth, constraints.maxHeight) {
                place1.placeRelative(0,0 )
        }
        println("policy ${res.width} ${res.height}")
        res
    }
}
