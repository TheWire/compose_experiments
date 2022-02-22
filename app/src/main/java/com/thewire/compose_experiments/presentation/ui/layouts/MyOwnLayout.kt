package com.thewire.compose_experiments.presentation.ui.layouts

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.Constraints

@Composable
fun MyOwnLayout(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    image: Painter,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = {
            header()
            content()
            Image(
                modifier = Modifier
                    .animateContentSize()
                    .fillMaxSize()
                    .background(Color.Red),
                painter = image,
                contentDescription = "image",
                contentScale = ContentScale.Crop,
            )
        }
    ) { measurables, constraints ->
        printConstraints("constraints", constraints)
        val topConstraints = constraints.copy(
            minHeight = measurables[0].minIntrinsicHeight(constraints.maxWidth),
            maxHeight = minOf(
                measurables[0].maxIntrinsicHeight(constraints.minWidth),
                constraints.maxHeight
            )
        )
        printConstraints("topConstraints", topConstraints)
        val lowerConstraints = constraints.copy(
            minHeight = maxOf(constraints.minHeight - topConstraints.maxHeight, 0),
            maxHeight = constraints.maxHeight - topConstraints.minHeight,
        )
        printConstraints("lowerConstraints", lowerConstraints)
        val aspectRatio = image.intrinsicSize.height / image.intrinsicSize.width
        val imageConstraints = lowerConstraints.copy(
            minWidth = minOf(
                (lowerConstraints.minHeight / aspectRatio).toInt(),
                maxOf(
                    constraints.minWidth - measurables[1].minIntrinsicWidth(lowerConstraints.minHeight),
                    0
                )
            ),
            maxWidth = minOf(
                (lowerConstraints.maxHeight / aspectRatio).toInt(),
                constraints.maxWidth - measurables[1].minIntrinsicWidth(lowerConstraints.maxHeight)
            ),
        )
        val place3 = measurables[2].measure(imageConstraints)
        printPlace("place3", place3)
        printConstraints("imageConstraints", imageConstraints)
        val bodyConstraints = lowerConstraints.copy(
            minWidth = measurables[1].minIntrinsicWidth(lowerConstraints.minHeight),
            maxWidth = constraints.maxWidth - place3.width,
        )
        printConstraints("bodyConstraints", bodyConstraints)

        val place2 = measurables[1].measure(bodyConstraints)
        printPlace("place2", place2)


        val topComposableConstraints = topConstraints.copy(
            maxWidth = maxOf(
                minOf(
                    place2.width + place3.width,
                    constraints.maxWidth
                ), constraints.minWidth
            )
        )
        printConstraints("topComposableConstraints", topComposableConstraints)
        val place1 = measurables[0].measure(topComposableConstraints)
        printPlace("place1", place1)
        layout(
            place1.width,
            place1.height + place3.height
        ) {
            var yPosition = 0
            place1.placeRelative(0, 0)
            yPosition += place1.height
            place2.placeRelative(0, yPosition)
            val place3Offset = maxOf(place1.width - (place2.width + place3.width), 0)
            place3.placeRelative(place2.width + place3Offset, yPosition)
        }
    }
}

fun printConstraints(name: String = "", constraint: Constraints) {
    println("$name ${constraint.minWidth} ${constraint.maxWidth} ${constraint.minHeight} ${constraint.maxHeight}")
}

fun printPlace(name: String = "", place: Placeable) {
    println("$name ${place.width} ${place.height}")
}