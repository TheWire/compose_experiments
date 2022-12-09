package com.thewire.compose_experiments.presentation


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thewire.compose_experiments.presentation.ui.RowTest
import com.thewire.compose_experiments.presentation.ui.experiemental15.ExperimentalViewModel15
import com.thewire.compose_experiments.presentation.ui.experiment2.ExperimentalViewModel2
import com.thewire.compose_experiments.presentation.ui.experimental1.ExperimentalViewModel1
import com.thewire.compose_experiments.presentation.ui.experimental3.ExperimentalViewModel3
import com.thewire.compose_experiments.presentation.ui.experimental9.ExperimentalViewModel9
import com.thewire.compose_experiments.presentation.ui.screens.*
import com.thewire.compose_experiments.presentation.ui.theme.Compose_experimentsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_experimentsTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "NAV_ROUTE") {
                    composable(route = "NAV_ROUTE") { navbackStackEntry ->
                        NavScreen(navController)
                    }
                    composable(route = "TEST_ROUTE_1") { navbackStackEntry ->
                        val viewModel1: ExperimentalViewModel1 by viewModels()
                        lifecycle.addObserver(viewModel1)
                        Screen1(viewModel = viewModel1, navController = navController)
                    }
                    composable(route = "TEST_ROUTE_2") { navbackStackEntry ->
                        val viewModel2: ExperimentalViewModel2 by viewModels()
                        Screen2(viewModel = viewModel2, navController)
                    }
                    composable(route = "TEST_ROUTE_3") { navbackStackEntry ->
                        val viewModel3: ExperimentalViewModel3 by viewModels()
                        Screen3(viewModel = viewModel3, navController)
                    }
                    composable(route = "TEST_ROUTE_4") { navbackStackEntry ->
                        Screen4()
                    }
                    composable(route = "TEST_ROUTE_5") { navbackStackEntry ->
                        Screen5()
                    }
                    composable(route = "TEST_ROUTE_6") { navbackStackEntry ->
                        Screen6()
                    }
                    composable(route = "TEST_ROUTE_7") { navbackStackEntry ->
                        Screen7()
                    }
                    composable(route = "TEST_ROUTE_8") { navbackStackEntry ->
                        Screen8()
                    }
                    composable(route = "TEST_ROUTE_9") { navbackStackEntry ->
                        val viewModel9: ExperimentalViewModel9 by viewModels()
                        Screen9(viewModel = viewModel9)
                    }
                    composable(route = "TEST_ROUTE_10") { navbackStackEntry ->
                        Screen10()
                    }
                    composable(route = "TEST_ROUTE_11") { navbackStackEntry ->
                        Screen11()
                    }
                    composable(route = "TEST_ROUTE_12") { navbackStackEntry ->
                        Screen12()
                    }
                    composable(route = "TEST_ROUTE_13") { navbackStackEntry ->
                        Screen13()
                    }
                    composable(route = "TEST_ROUTE_14") { navbackStackEntry ->
                        Screen14()
                    }
                    composable(route = "TEST_ROUTE_15") { navbackStackEntry ->
                        val viewModel15: ExperimentalViewModel15 by viewModels()
                        lifecycle.addObserver(viewModel15)
                        Screen15(viewModel = viewModel15)
                    }
                    composable(route = "TEST_ROUTE_16") { navbackStackEntry ->
                        Screen16()
                    }
                    composable(route = "TEST_ROUTE_17") { navbackStackEntry ->
                        Screen17()
                    }
                    composable(route = "TEST_ROUTE_18") { navbackStackEntry ->
                        Screen18()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MainPreview() {
    RowTest()
}



