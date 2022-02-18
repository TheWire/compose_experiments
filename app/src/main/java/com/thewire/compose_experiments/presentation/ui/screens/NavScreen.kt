package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun NavScreen(
    navController: NavController
) {
    Column() {
        Button(
            onClick = { navController.navigate("TEST_ROUTE_1")}
        ) {
            Text("To Screen 1")
        }
        Button(
            onClick = { navController.navigate("TEST_ROUTE_2")}
        ) {
            Text("To Screen 2")
        }
        Button(
            onClick = { navController.navigate("TEST_ROUTE_3")}
        ) {
            Text("To Screen 3")
        }
        Button(
            onClick = { navController.navigate("TEST_ROUTE_4")}
        ) {
            Text("To Screen 4")
        }
        Button(
            onClick = { navController.navigate("TEST_ROUTE_5")}
        ) {
            Text("To Screen 5")
        }
        Button(
            onClick = { navController.navigate("TEST_ROUTE_6")}
        ) {
            Text("To Screen 6")
        }
        Button(
            onClick = { navController.navigate("TEST_ROUTE_7")}
        ) {
            Text("To Screen 7")
        }
        Button(
            onClick = { navController.navigate("TEST_ROUTE_8")}
        ) {
            Text("To Screen 8")
        }
    }
}