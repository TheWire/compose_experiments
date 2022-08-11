package com.thewire.compose_experiments.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties

@Composable
fun Wrap() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            color = Color.Magenta,
            modifier = Modifier.wrapContentSize(align = Alignment.TopCenter)
        ) {
            Text(
                text = "Wrapped content",
                modifier = Modifier,
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Composable
fun RowTest() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .background(color = Color.LightGray),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            ColoredBar(Color.Magenta)
            ColoredBar(Color.Red)
            ColoredBar(Color.Yellow)
            ColoredBar(Color.Green)
            ColoredBar(Color.Cyan)
            ColoredBar(Color.Blue)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, androidx.compose.ui.ExperimentalComposeUiApi::class)
@Composable
fun SomeTextThing() {
    Surface() {
        testLazyGrid()
        TextPos()
        CardThing()
        Column() {
            dropdownMenu()
            otherStuff()
            icons()
            val suggestions = listOf("a", "aa", "bb", "cc", "ab")
            AddSearchParam(
                suggestions = suggestions
            )
        }
    }
}

@Composable
fun ColoredBar(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .width(40.dp)
            .height(600.dp)
    ) {

    }
}

@ExperimentalFoundationApi
@Composable()
fun testLazyGrid() {
    val list = (1..600).map { it.toString() }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp)
    ) {
        items(list.size) { index ->
            Text("item ${list[index]}")
        }
    }
}

@Composable
fun testLayout() {
    WrapContainer(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        for (i in 0..600) {
            Text("item $i")
        }
    }
}

@Composable
fun WrapContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        Layout(
            content = content
        ) { measurables, constraints ->

            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }
            layout(constraints.maxWidth, constraints.maxHeight) {
                var yPosition = 0
                var xPosition = 0
                var largestY = 0
                placeables.forEach { placeable ->
                    if (xPosition + placeable.width > constraints.maxWidth) {
                        xPosition = 0
                        yPosition += largestY
                    }
                    placeable.placeRelative(xPosition, yPosition)
                    if (placeable.width > constraints.maxWidth) {
                        xPosition = 0
                    } else {
                        xPosition += placeable.width
                    }
                    largestY = maxOf(largestY, placeable.height)
                }
            }
        }
    }

}

@Composable
fun TextPos() {
    Box(
        modifier = Modifier
            .background(
                color = Color.Magenta,
                shape = RoundedCornerShape(30.dp)
            )
    ) {
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = "how is this text positioned"
        )
    }
}

@Composable
fun CardThing() {
    Surface(
        modifier = Modifier
            .width(300.dp)
            .height(300.dp),
        color = Color.LightGray,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = Color.DarkGray
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Cyan
                    )
            ) {
                Text("some text")
                Column(
                    modifier = Modifier
                        .background(
                            color = Color.Magenta
                        )
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.End),
                        text = "some more text"
                    )
                    Text(
                        modifier = Modifier.align(Alignment.End),
                        text = "some more text"
                    )
                }


            }
            Box(
                modifier = Modifier
                    .background(
                        color = Color.Magenta
                    )
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart),
                    text = "some box text"
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    text = "some more box text",
                )
            }
        }
    }
}

@Composable
fun dropdownMenu() {
    Column() {
        TextField(
            value = "some text",
            onValueChange = {}
        )
        DropdownMenu(
            expanded = true,
            onDismissRequest = {}
        ) {
            DropdownMenuItem(
                enabled = true,
                onClick = { println("dropdown menu 1") }
            ) {
                Text("dropdown menu 1")
            }
            Text(
                text = "item 1",
                modifier = Modifier
                    .clickable { println("item 1") }
            )
            Text("item 2")
            Text("item 3")
        }
    }

}

@Composable
fun otherStuff() {
    Column() {
        Text("column item 1")
        Text("column item 2")
        Text("column item 3")
        Text("column item 4")
    }
}

@Composable
fun icons() {
    Column(
        modifier = Modifier
            .scrollable(
                orientation = Orientation.Vertical,
                state = remember { ScrollState(0) },
                enabled = true,
            )
    ) {
        Row() {
            iconWithTitle(Icons.Filled.Search, "search")
            iconWithTitle(Icons.Filled.CheckCircle, "CheckCircle")
            iconWithTitle(Icons.Filled.Check, "Check")
            iconWithTitle(Icons.Filled.Delete, "Delete")
            iconWithTitle(Icons.Filled.Phone, "Phone")

        }
        Row() {
            iconWithTitle(Icons.Filled.ArrowBack, "ArrowBack")
            iconWithTitle(Icons.Filled.FavoriteBorder, "FavoriteBorder")
            iconWithTitle(Icons.Filled.Favorite, "Favorite")
            iconWithTitle(Icons.Filled.AccountBox, "AccountBox")
        }
        Row() {
            iconWithTitle(Icons.Filled.AccountCircle, "AccountCircle")
            iconWithTitle(Icons.Filled.Add, "Add")
            iconWithTitle(Icons.Filled.AddCircle, "AddCircle")
            iconWithTitle(Icons.Filled.ArrowDropDown, "ArrowDropDown")
        }
        Row() {
            iconWithTitle(Icons.Filled.ArrowForward, "ArrowForward")
            iconWithTitle(Icons.Filled.Build, "Build")
            iconWithTitle(Icons.Filled.Call, "Call")
            iconWithTitle(Icons.Filled.Clear, "Clear")
        }
        Row() {
            iconWithTitle(Icons.Filled.Close, "Close")
            iconWithTitle(Icons.Filled.Create, "Create")
            iconWithTitle(Icons.Filled.DateRange, "DateRange")
            iconWithTitle(Icons.Filled.Done, "Done")
        }
        Row() {
            iconWithTitle(Icons.Filled.Edit, "Edit")
            iconWithTitle(Icons.Filled.Email, "Email")
            iconWithTitle(Icons.Filled.ExitToApp, "ExitToApp")
            iconWithTitle(Icons.Filled.Face, "Face")
        }
        Row() {
            iconWithTitle(Icons.Filled.Home, "Home")
            iconWithTitle(Icons.Filled.Info, "Info")
            iconWithTitle(Icons.Filled.KeyboardArrowDown, "KeyboardArrowDown")
            iconWithTitle(Icons.Filled.KeyboardArrowLeft, "KeyboardArrowLeft")
        }
        Row() {
            iconWithTitle(Icons.Filled.KeyboardArrowRight, "KeyboardArrowRight")
            iconWithTitle(Icons.Filled.KeyboardArrowUp, "KeyboardArrowUp")
            iconWithTitle(Icons.Filled.List, "List")
            iconWithTitle(Icons.Filled.LocationOn, "LocationOn")
        }
        Row() {
            iconWithTitle(Icons.Filled.Lock, "Lock")
            iconWithTitle(Icons.Filled.MailOutline, "MailOutline")
            iconWithTitle(Icons.Filled.Menu, "Menu")
            iconWithTitle(Icons.Filled.MoreVert, "MoreVert")
        }
        Row() {
            iconWithTitle(Icons.Filled.Person, "Person")
            iconWithTitle(Icons.Filled.Place, "Place")
            iconWithTitle(Icons.Filled.PlayArrow, "PlayArrow")
            iconWithTitle(Icons.Filled.Refresh, "Refresh")
        }
        Row() {
            iconWithTitle(Icons.Filled.Send, "Send")
            iconWithTitle(Icons.Filled.Settings, "Settings")
            iconWithTitle(Icons.Filled.Share, "Share")
            iconWithTitle(Icons.Filled.ShoppingCart, "ShoppingCart")
        }
        Row() {
            iconWithTitle(Icons.Filled.Star, "Star")
            iconWithTitle(Icons.Filled.ThumbUp, "ThumbUp")
            iconWithTitle(Icons.Filled.Warning, "Warning")
        }
    }
}

@Composable()
fun iconWithTitle(
    imageVector: ImageVector,
    title: String,
) {
    Column() {
        Icon(
            imageVector = imageVector,
            contentDescription = title
        )
        Text(title)
    }
    Spacer(modifier = Modifier.width(12.dp))
}

@ExperimentalComposeUiApi
@Composable
fun AddSearchParam(
    modifier: Modifier = Modifier,
    suggestions: List<String>
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    var focusRequesterSet = remember { mutableStateOf(false) }
    val searchString = remember { mutableStateOf("") }

    Column {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onFocusChanged {
                    if (!it.hasFocus && focusRequesterSet.value) {

                    }
                },
            value = searchString.value,
            onValueChange = {
                searchString.value = it
            },
            label = { Text("Search") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController?.hide()
                }
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search"
                )
            }
        )
        suggestionsList(suggestions = suggestions)
    }

    Spacer(modifier = Modifier.height(300.dp))

    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = searchString.value,
        onValueChange = {
            searchString.value = it
        },
    )

    DisposableEffect(Unit) {
        focusRequester.requestFocus()
        focusRequesterSet.value = false
        onDispose { }
    }

}

@Composable
fun suggestionsList(
    modifier: Modifier = Modifier,
    suggestions: List<String>,
) {
    val exp = remember { mutableStateOf(true) }
    DropdownMenu(
        modifier = Modifier.background(color = Color.Magenta),
        expanded = exp.value,
        onDismissRequest = {},
        properties = PopupProperties(
            focusable = false,
        )
    ) {
        suggestions.forEach {
            DropdownMenuItem(
                enabled = true,
                onClick = { exp.value = false }
            ) {
                Text(
                    text = it
                )
            }

        }
    }

}