package com.thewire.compose_experiments.presentation


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.thewire.compose_experiments.presentation.ui.RowTest
import com.thewire.compose_experiments.presentation.ui.experiemental15.ExperimentalViewModel15
import com.thewire.compose_experiments.presentation.ui.experiment2.ExperimentalViewModel2
import com.thewire.compose_experiments.presentation.ui.experimental1.ExperimentalViewModel1
import com.thewire.compose_experiments.presentation.ui.experimental19.ExperimentalViewModel19
import com.thewire.compose_experiments.presentation.ui.experimental23.ExperimentalViewModel23
import com.thewire.compose_experiments.presentation.ui.experimental3.ExperimentalViewModel3
import com.thewire.compose_experiments.presentation.ui.experimental9.ExperimentalViewModel9
import com.thewire.compose_experiments.presentation.ui.screens.NavScreen
import com.thewire.compose_experiments.presentation.ui.screens.Screen1
import com.thewire.compose_experiments.presentation.ui.screens.Screen10
import com.thewire.compose_experiments.presentation.ui.screens.Screen11
import com.thewire.compose_experiments.presentation.ui.screens.Screen12
import com.thewire.compose_experiments.presentation.ui.screens.Screen13
import com.thewire.compose_experiments.presentation.ui.screens.Screen14
import com.thewire.compose_experiments.presentation.ui.screens.Screen15
import com.thewire.compose_experiments.presentation.ui.screens.Screen16
import com.thewire.compose_experiments.presentation.ui.screens.Screen17
import com.thewire.compose_experiments.presentation.ui.screens.Screen18
import com.thewire.compose_experiments.presentation.ui.screens.Screen19
import com.thewire.compose_experiments.presentation.ui.screens.Screen2
import com.thewire.compose_experiments.presentation.ui.screens.Screen20
import com.thewire.compose_experiments.presentation.ui.screens.Screen21
import com.thewire.compose_experiments.presentation.ui.screens.Screen22
import com.thewire.compose_experiments.presentation.ui.screens.Screen23
import com.thewire.compose_experiments.presentation.ui.screens.Screen24
import com.thewire.compose_experiments.presentation.ui.screens.Screen25
import com.thewire.compose_experiments.presentation.ui.screens.Screen26
import com.thewire.compose_experiments.presentation.ui.screens.Screen3
import com.thewire.compose_experiments.presentation.ui.screens.Screen4
import com.thewire.compose_experiments.presentation.ui.screens.Screen5
import com.thewire.compose_experiments.presentation.ui.screens.Screen6
import com.thewire.compose_experiments.presentation.ui.screens.Screen7
import com.thewire.compose_experiments.presentation.ui.screens.Screen8
import com.thewire.compose_experiments.presentation.ui.screens.Screen9
import com.thewire.compose_experiments.presentation.ui.theme.Compose_experimentsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_experimentsTheme(darkTheme = false) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "NAV_ROUTE") {
                    composable(route = "NAV_ROUTE") { navBackStackEntry ->
                        NavScreen(navController)
                    }
                    composable(route = "TEST_ROUTE_1") { navBackStackEntry ->
                        val viewModel1: ExperimentalViewModel1 = viewModel()
                        lifecycle.addObserver(viewModel1)
                        Screen1(viewModel = viewModel1, navController = navController)
                    }
                    composable(route = "TEST_ROUTE_2") { navBackStackEntry ->
                        val viewModel2: ExperimentalViewModel2 = viewModel()
                        Screen2(viewModel = viewModel2, navController)
                    }
                    composable(route = "TEST_ROUTE_3") { navBackStackEntry ->
                        val viewModel3: ExperimentalViewModel3 = viewModel()
                        Screen3(viewModel = viewModel3, navController)
                    }
                    composable(route = "TEST_ROUTE_4") { navBackStackEntry ->
                        Screen4()
                    }
                    composable(route = "TEST_ROUTE_5") { navBackStackEntry ->
                        Screen5()
                    }
                    composable(route = "TEST_ROUTE_6") { navBackStackEntry ->
                        Screen6()
                    }
                    composable(route = "TEST_ROUTE_7") { navBackStackEntry ->
                        Screen7()
                    }
                    composable(route = "TEST_ROUTE_8") { navBackStackEntry ->
                        Screen8()
                    }
                    composable(route = "TEST_ROUTE_9") { navBackStackEntry ->
                        val viewModel9: ExperimentalViewModel9 = viewModel()
                        Screen9(viewModel = viewModel9)
                    }
                    composable(route = "TEST_ROUTE_10") { navBackStackEntry ->
                        Screen10()
                    }
                    composable(route = "TEST_ROUTE_11") { navBackStackEntry ->
                        Screen11()
                    }
                    composable(route = "TEST_ROUTE_12") { navBackStackEntry ->
                        Screen12()
                    }
                    composable(route = "TEST_ROUTE_13") { navBackStackEntry ->
                        Screen13()
                    }
                    composable(route = "TEST_ROUTE_14") { navBackStackEntry ->
                        Screen14()
                    }
                    composable(route = "TEST_ROUTE_15") { navBackStackEntry ->
                        val viewModel15: ExperimentalViewModel15 = viewModel()
                        lifecycle.addObserver(viewModel15)
                        Screen15(viewModel = viewModel15)
                    }
                    composable(route = "TEST_ROUTE_16") { navBackStackEntry ->
                        Screen16()
                    }
                    composable(route = "TEST_ROUTE_17") { navBackStackEntry ->
                        Screen17()
                    }
                    composable(route = "TEST_ROUTE_18") { navBackStackEntry ->
                        Screen18()
                    }
                    composable(route = "TEST_ROUTE_19") { navBackStackEntry ->
                        val viewModel19: ExperimentalViewModel19 = viewModel()
                        Screen19(viewModel = viewModel19)
                    }
                    composable(route = "TEST_ROUTE_20") { navBackStackEntry ->
                        Screen20()
                    }
                    composable(route = "TEST_ROUTE_21") { navBackStackEntry ->
                        Screen21()
                    }
                    composable(route = "TEST_ROUTE_22") { navBackStackEntry ->
                        Screen22()
                    }
                    composable(
                        route = "TEST_ROUTE_23/{id}/{str}",
                        arguments = listOf(
                            navArgument("id") { type = NavType.IntType },
                            navArgument("str") { type = NavType.StringType },
                        )
                    ) { navBackStackEntry ->
                        val id  = navBackStackEntry.arguments?.getInt("id") ?: -2
                        val str  = navBackStackEntry.arguments?.getString("str") ?: "default"
                        val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current)
                        val viewModel23: ExperimentalViewModel23 =
                            viewModel(viewModelStoreOwner, "LaunchViewModel")
//                        val viewModel23: ExperimentalViewModel23 by viewModel()
                        viewModel23.id = id
                        Screen23(viewModel = viewModel23, str = str, navController=navController)
                    }
                    composable(route = "TEST_ROUTE_24") { navBackStackEntry ->
                        Screen24()
                    }
                    composable(route = "TEST_ROUTE_25") { navBackStackEntry ->
                        Screen25()
                    }
                    composable(route = "TEST_ROUTE_26") { navBackStackEntry ->
                        Screen26()
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



