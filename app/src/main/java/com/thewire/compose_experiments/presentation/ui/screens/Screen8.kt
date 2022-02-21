package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.solver.state.State
import com.thewire.compose_experiments.R
import com.thewire.compose_experiments.presentation.ui.theme.Compose_experimentsTheme

@Composable
fun Screen8() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green)
    ) {
        Card(
            modifier = Modifier
                .widthIn(0.dp, 380.dp)
                .fillMaxHeight(),
            backgroundColor = Color.Magenta
        ) {
            MyOwnLayout(
                modifier = Modifier
                    .background(color = Color.Yellow),
                header = {
                    Row(
                        modifier = Modifier
                            .background(color = Color.Cyan),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(1f),
                            text = "This is a Heading that is even longer and hopefully extends to multiple lines",
                            style = MaterialTheme.typography.h5,
                        )
                        Icon(
                            imageVector = Icons.Filled.AccountBox,
                            contentDescription = "icons"
                        )
                    }
                },
                image = painterResource(R.drawable.starship)
            ) {
                Column(
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .width(200.dp)
                ) {
                    Text(
                        "here is some sample text" +
                                "and her is some more sample text"
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum cursus efficitur tortor, tempus congue felis auctor at. Ut consequat facilisis sollicitudin. Donec a egestas purus. Praesent nunc libero, fringilla ac bibendum a, tincidunt at ex. Ut congue quam in ultricies efficitur. Sed nec ipsum ultrices sapien ornare luctus vitae sed neque. Nulla eu mauris in purus hendrerit rhoncus. Etiam accumsan gravida metus sit amet sodales. Nunc non sem semper, tempus erat sed, sollicitudin erat. Phasellus imperdiet nisi vel velit malesuada, quis ultricies risus laoreet. Nullam nec vestibulum arcu. Nunc imperdiet ornare ex mattis accumsan. Donec sed mattis mauris, ac elementum lorem. Nunc iaculis massa eros, sit amet consectetur lacus rhoncus eu.\n" +
                            "\n" +
                            "Mauris vel ornare nibh. Vestibulum varius odio id lectus suscipit, eget feugiat ante luctus. Integer eleifend egestas hendrerit. Etiam tristique laoreet magna, eu vulputate libero commodo sed. Sed aliquet velit nisi, vel semper erat laoreet eu. Proin vulputate lacus tortor, vel tristique quam efficitur id. Quisque a sapien venenatis, consectetur velit a, blandit dui. Nulla a mattis ex, sit amet tincidunt nisi. Phasellus eu dignissim leo.")
                    Text("some extra text and even more text")
                    Text(
                        "here is some sample text" +
                                "and her is some more sample text"
                    )
                    Text(
                        "here is some sample text" +
                                "and her is some more sample text"
                    )
                    Text(
                        "here is some sample text" +
                                "and her is some more sample text"
                    )
                    Text(
                        "here is some sample text" +
                                "and her is some more sample text"
                    )
                    Text(
                        "here is some sample text" +
                                "and her is some more sample text"
                    )
                    Text(
                        "here is some sample text" +
                                "and her is some more sample text"
                    )
                    Text(
                        "here is some sample text" +
                                "and her is some more sample text"
                    )
                    Text(
                        "here is some sample text" +
                                "and her is some more sample text"
                    )
                    Text(
                        "here is some sample text" +
                                "and her is some more sample text"
                    )
                    Text("This is the end text")
                }
            }
        }
    }

}

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
            maxHeight = minOf(measurables[0].maxIntrinsicHeight(constraints.minWidth), constraints.maxHeight)
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
                maxOf(constraints.minWidth - measurables[1].minIntrinsicWidth(lowerConstraints.minHeight), 0)
            ),
            maxWidth = minOf(
                (lowerConstraints.maxHeight / aspectRatio).toInt(),
                constraints.maxWidth - measurables[1].minIntrinsicWidth(lowerConstraints.maxHeight)
            ),
        )
        printConstraints("imageConstraints", imageConstraints)
        val bodyConstraints = lowerConstraints.copy(
            minWidth = measurables[1].minIntrinsicWidth(lowerConstraints.minHeight),
            maxWidth = constraints.maxWidth - imageConstraints.minWidth,
        )
        printConstraints("bodyConstraints", bodyConstraints)

        val place2 = measurables[1].measure(bodyConstraints)
        printPlace("place2", place2)
        val place3 = measurables[2].measure(imageConstraints)
        printPlace("place3", place3)

        val topComposableConstraints = topConstraints.copy(
            minWidth = maxOf(
                place2.width + place3.width,
                constraints.minWidth
            ),
            maxWidth = minOf(
                imageConstraints.maxWidth + bodyConstraints.maxWidth,
                constraints.maxWidth
            )
        )
        printConstraints("topComposableConstraints", topComposableConstraints)
        val place1 = measurables[0].measure(topComposableConstraints)
        printPlace("place1", place1)

        layout(minOf(maxOf(place1.width, place2.width + place3.width), constraints.maxWidth), minOf(place1.height + place3.height, constraints.maxHeight)) {
            var yPosition = 0
            place1.placeRelative(0, 0)
            yPosition += place1.height
            place2.placeRelative(0, yPosition)
            val place3Offset = maxOf(place1.width - (place2.width + place3.width),0)
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

@Preview
@Composable
fun Screen8Preview() {
    Compose_experimentsTheme {
        Screen8()
    }
}