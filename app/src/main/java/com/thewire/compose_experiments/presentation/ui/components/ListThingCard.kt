package com.thewire.compose_experiments.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thewire.compose_experiments.R
import com.thewire.compose_experiments.presentation.ui.experimental3.ExampleListThing
import com.thewire.compose_experiments.presentation.ui.layouts.MyOwnLayout
import com.thewire.compose_experiments.presentation.ui.theme.Compose_experimentsTheme

@Composable
fun ListThingCard(
    modifier: Modifier = Modifier,
    listThing: ExampleListThing
) {
    Card(
        modifier = modifier,
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
                        text = listThing.heading,
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
                    .width(150.dp)
            ) {
                Text(
                    listThing.body
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text("some extra text and even more text")

            }
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