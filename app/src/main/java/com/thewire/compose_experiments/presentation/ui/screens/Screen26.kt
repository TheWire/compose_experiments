package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun Screen26() {
    Column() {
        Layout1()
    }
}

@Preview
@Composable
fun Prev() {
    Screen26()
}
//comment
@Composable
fun Layout1() {
    ConstraintLayout {
        val (button, title, icon, text) = createRefs()
        Button(
            onClick = {},
            modifier = Modifier
                .constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        ) {
            Text("Button")
        }
        Text(
            "Title",
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(button.end, margin = 16.dp)
                end.linkTo(icon.start, margin = 16.dp)
            }
        )
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "icon",
            modifier = Modifier.constrainAs(icon) {
                top.linkTo(parent.top, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        )
        Text(
            "ridens tale cu te purus graecis iudicabit nec nonumes neglegentur dicit ante " +
                    "impetus antiopam parturient reprimique doctus porro vim malesuada dolorum " +
                    "utroque atomorum voluptaria mel mel vulputate an nibh vel pellentesque oratio " +
                    "comprehensam facilisis harum numquam torquent dicam ac iisque senectus auctor " +
                    "varius veritus himenaeos ultricies efficiantur accommodare",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(title.bottom, margin = 32.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        )
    }
}