package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thewire.compose_experiments.R

@Composable
fun Screen25() {
    Column(modifier =
    Modifier.fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        WebCard()
        SpaceThing()
    }
}

@Composable
fun SpaceThing() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(Icons.Default.Menu, contentDescription = "menu")
        Row() {
            Text("Title Text")
            Icon(Icons.Default.Add, contentDescription = "add")
        }
        Icon(Icons.Default.Close, contentDescription = "close")
    }
}

@Composable
fun WebCard() {
    Card() {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(48.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.michael_dam_mez3pofgs_k_unsplash),
                contentDescription = "test image"
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text("Founder And Thinker", fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.roboto_regular)))
                    Text("Jack Mane", fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.roboto_bold)))
                }
                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(
                        color = Color.Yellow,
                        modifier = Modifier
                            .height(24.dp)
                            .width(4.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "facebook"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.twitter),
                        contentDescription = "twitter"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "google"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.pinterest),
                        contentDescription = "pinterest"
                    )
                }
            }
        }
    }

}