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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thewire.compose_experiments.R

@Composable
fun Screen5() {
    Card(
        modifier = Modifier
            .widthIn(300.dp, 500.dp)
            .fillMaxHeight(),
        backgroundColor = Color.LightGray,
    ) {
        ConstraintLayout {
            val (heading, body, image) = createRefs()
            Row(
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .constrainAs(heading) {
                        top.linkTo(parent.top)
                        absoluteLeft.linkTo(parent.absoluteLeft)
                    },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "This is a Heading",
                    style = MaterialTheme.typography.h5,
                )
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "icons"
                )
            }
            Text(
                text = "this is some text and some more text",
                modifier = Modifier
                    .background(color = Color.Blue)
                    .width(200.dp)
                    .constrainAs(body) {
                        top.linkTo(heading.bottom)
                        absoluteLeft.linkTo(parent.absoluteLeft)
                    }
            )
            val p = painterResource(R.drawable.starship).intrinsicSize
            Image(
                modifier = Modifier
                    .background(color = Color.Magenta)
                    .height(300.dp)
                    .layoutImageTheWayIWant(
                        heightOfImage = p.height,
                        widthOfImage = p.width
                    )
                    .constrainAs(image) {
                        top.linkTo(heading.bottom)
                        absoluteRight.linkTo(parent.absoluteRight)
                        absoluteLeft.linkTo(body.absoluteRight)
                    },
                painter = painterResource(R.drawable.starship),
                contentDescription = "starship",
                contentScale = ContentScale.Crop
            )
        }
    }
}

fun Modifier.layoutImageTheWayIWant(
    heightOfImage: Float,
    widthOfImage: Float
) = layout { measurable: Measurable, constraints: Constraints ->
    val aspectRatio = heightOfImage / widthOfImage
    val placeable = measurable.measure(constraints)
    val height = placeable.height
    val width = (placeable.height / aspectRatio).toInt()
    layout(width = width, height = height) {
        placeable.placeRelative(0, 0)
    }
}