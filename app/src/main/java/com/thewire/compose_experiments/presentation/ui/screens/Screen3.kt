package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.thewire.compose_experiments.presentation.ui.components.ListThingCard
import com.thewire.compose_experiments.presentation.ui.components.OrientationLazy
import com.thewire.compose_experiments.presentation.ui.experimental3.ExperimentalViewModel3

@Composable
fun Screen3(
    viewModel: ExperimentalViewModel3,
    navController: NavController
) {
    Column() {
        OrientationLazy() { modifier ->
            itemsIndexed(items = viewModel.list) { index, thing ->
                ListThingCard(
                    modifier = modifier
                        .padding(10.dp),
                    listThing = thing,
                    imageCall = viewModel::getImage,
                )
            }
        }
    }


}

