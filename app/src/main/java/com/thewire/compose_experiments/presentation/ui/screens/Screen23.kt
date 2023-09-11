package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.thewire.compose_experiments.presentation.ui.experimental23.ExperimentalViewModel23

@Composable
fun Screen23(viewModel: ExperimentalViewModel23, str: String, navController: NavController) {
    Column() {
        Text("Screen 23")
        Text(str)
        Text(viewModel.id.toString())
        Text(viewModel.someVal.toString())
        Button(
            onClick = { viewModel.someVal = viewModel.someVal + 1}
        ) {
            Text("increment")
        }
        Button(
            onClick = { navController.navigate("TEST_ROUTE_23/${viewModel.id+1}/${str}-23 again")}
        ) {
            Text("to 23 again")
        }
        OtherThing(num = viewModel.someVal)
    }
}

@Composable
fun OtherThing(num: Int) {
    Column() {
        Text(num.toString())
        AnotherThing(num = num)
    }
    
}

@Composable 
fun AnotherThing(num: Int) {
    Text(num.toString())
}