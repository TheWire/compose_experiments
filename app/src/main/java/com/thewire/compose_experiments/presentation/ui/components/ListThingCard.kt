package com.thewire.compose_experiments.presentation.ui.components

import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.thewire.compose_experiments.R
import com.thewire.compose_experiments.presentation.ui.experimental3.ExampleListThing
import com.thewire.compose_experiments.presentation.ui.theme.Compose_experimentsTheme

@Composable
fun ListThingCard(
    modifier: Modifier = Modifier,
    listThing: ExampleListThing
) {
    Card(
        modifier = Modifier
            .widthIn(300.dp, 400.dp)
            .fillMaxHeight()
            .padding(6.dp),
        backgroundColor = Color.LightGray,
    ) {
        ConstraintLayout(
            modifier = Modifier
        ) {
            val (heading, body, image) = createRefs()
            Row(
                modifier = Modifier
                    .width(500.dp)
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
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Magenta)
                    .constrainAs(image) {
                        top.linkTo(heading.bottom)
                        absoluteRight.linkTo(parent.absoluteRight)
                        absoluteLeft.linkTo(body.absoluteRight)
                    },
                painter = painterResource(R.drawable.starship),
                contentDescription = "starship",
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview
@Composable
fun PreviewThing() {
    Compose_experimentsTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val thing = ExampleListThing(
                heading = "Preview Header",
                body = "When the ego of awareness facilitates the graces of the thing," +
                        " the conclusion will know teacher." +
                        "Navis resisteres, tanquam primus ionicis tormento.Blueberries paste" +
                        " has to have a divided, aged zucchini component.God, never scrape a son."
            )
            ListThingCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                listThing = thing
            )
        }
    }
}