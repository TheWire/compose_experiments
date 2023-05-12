package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.thewire.compose_experiments.R
import kotlin.random.Random

@Composable
fun Screen25() {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WebCard()
        AltCard()
        SpaceThing()
        FilterGrid()
        FilterFlow()
        TabThing()
    }
}

@Preview
@Composable
fun Preview() {
    Screen25()
}

@Composable
fun Chip(text: String, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier
            .height(32.dp),
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Gray),
        contentPadding = PaddingValues(8.dp, 8.dp, 16.dp, 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                Icons.Default.Check,
                modifier = Modifier.size(18.dp),
                contentDescription = "menu"
            )
            Text(
                text = text,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 20.sp
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterFlow() {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
    ) {
        for (i in 0..9) {
            Chip(randomString(), modifier = Modifier.padding(0.dp, 8.dp))
        }
    }
}

fun randomString(): String {
    val num = Random.nextInt(0, 10)
    var str = ""
    for (i in 0..num) {
        str += Random.nextInt(97, 122).toChar()
    }
    return str
}

@Composable
fun FilterGrid() {
    LazyVerticalGrid(
        modifier = Modifier.height(150.dp),
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(9) {
            Chip("filter")
        }
    }
}

@Composable
fun AltCard() {
    Card() {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Box() {
                Row(
                    modifier = Modifier
                        .zIndex(1f)
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Divider(
                        color = Color.Yellow,
                        modifier = Modifier
                            .height(24.dp)
                            .width(4.dp)
                    )
                    Text(
                        "Title Here",
                        color = Color.White,
                        fontSize = 24.sp
                    )
                }
                Image(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.arnold_francisca_f77bh3inupe_unsplash),
                    contentDescription = "test image"
                )
            }
            Column(
                modifier = Modifier
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    "possit scripserit esse phasellus lorem appetere conubia natum atqui eripuit " +
                            "alienum inani fames finibus etiam eirmod offendit explicari dicat est " +
                            "platonem dolorem dolore postulant",
                    fontSize = 14.sp,
                )
                Button(onClick = {}) {
                    Text("Read More")
                }
            }
        }
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
fun TabThing() {
    var num by remember { mutableStateOf(0) }
    val tabs = listOf("Tab One", "Tab Two", "Tab Three")
    TabRow(selectedTabIndex = num) {
        tabs.forEachIndexed { index, name ->
            Tab(
                selected = num == index,
                onClick = { num = index }
            ) {
                Text(name)
            }
        }
    }
    when (num) {
        0 -> {
            Text(
                "ne non putent nostra habeo blandit lacus comprehensam luctus dicant scripserit" +
                        " sociis facilisi enim impetus noster quaeque non expetenda adhuc voluptatum vituperatoribus " +
                        "conclusionemque regione erat voluptatum atqui turpis curabitur sea dicant qualisque sententiae " +
                        "rutrum maluisset persecuti pretium interdum diam constituam auctor montes error sed vim " +
                        "lacinia semper hinc"
            )
        }
        1 -> { Text("Tab Two")}
        2-> { Text("Tab Three") }
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        "Founder And Thinker",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                    )
                    Text(
                        "Jack Mane",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold))
                    )
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