package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.thewire.compose_experiments.R

@Composable
fun Screen4() {
    BoxWithConstraints {
        val size = painterResource(R.drawable.starship).intrinsicSize
        val aspectRatio = size.width / size.height
        val imageHeight = maxHeight - 100.dp
        val imageWidth = imageHeight * aspectRatio
        Card(
            modifier = Modifier
                .wrapContentWidth()
                .height(500.dp),
            backgroundColor = Color.DarkGray
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .height(100.dp)
//                        .fillMaxWidth()
                        .background(color = Color.Green)
                )
                Row() {
                    Text(
                        modifier = Modifier
                            .width(100.dp)
                            .background(color = Color.Cyan),
                        text = "this is some text and some more text"
                    )
                    Image(
                        modifier = Modifier
                            .background(color = Color.Magenta)
                            .width(imageWidth)
                            .height(imageHeight),
                        painter = painterResource(R.drawable.starship),
                        contentDescription = "starship",
                    )
                }
            }
        }
    }
}