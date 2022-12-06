package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun NavScreen(
    navController: NavController
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Text("This is the drawer")
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Button(
                onClick = { navController.navigate("TEST_ROUTE_1") }
            ) {
                Text("To Screen 1")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_2") }
            ) {
                Text("To Screen 2")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_3") }
            ) {
                Text("To Screen 3")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_4") }
            ) {
                Text("To Screen 4")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_5") }
            ) {
                Text("To Screen 5")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_6") }
            ) {
                Text("To Screen 6")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_7") }
            ) {
                Text("To Screen 7")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_8") }
            ) {
                Text("To Screen 8")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_9") }
            ) {
                Text("To Screen 9")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_10") }
            ) {
                Text("To Screen 10")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_11") }
            ) {
                Text("To Screen 11")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_12") }
            ) {
                Text("To Screen 12")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_13") }
            ) {
                Text("To Screen 13")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_14") }
            ) {
                Text("To Screen 14")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_15") }
            ) {
                Text("YouTube Video")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_16") }
            ) {
                Text("Dialog")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_17") }
            ) {
                Text("WebView")
            }
            Button(
                onClick = { navController.navigate("TEST_ROUTE_18") }
            ) {
                Text("To Screen 18")
            }
            Button(
                onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }
            ) {
                Text("Open Drawer")
            }
        }
    }
}