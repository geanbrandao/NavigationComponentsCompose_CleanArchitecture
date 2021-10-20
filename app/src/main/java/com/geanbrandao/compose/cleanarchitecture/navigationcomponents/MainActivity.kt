package com.geanbrandao.compose.cleanarchitecture.navigationcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.Screen
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.bottom_navigation.BottomNavigationCustom
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.nav_graph.NavGraph
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.theme.NavigationComponentsComposeCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationComponentsComposeCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val bottomNavigationVisibilityState = remember {
                    mutableStateOf(value = true)
                }
                navController.addOnDestinationChangedListener { controller, destination, arguments ->
                    when (destination.route) {
                        Screen.Characters.route -> {
                            bottomNavigationVisibilityState.value = true
                        }
                        Screen.Episodes.route -> {
                            bottomNavigationVisibilityState.value = true
                        }
                        else -> {
                            bottomNavigationVisibilityState.value = false
                        }
                    }
                }

                Scaffold(
                    bottomBar = {
                        // pode ser colocado um bottom navigation custom mesmo
                        AnimatedVisibility(
                            visible = bottomNavigationVisibilityState.value,
                            enter = expandVertically(),
                            exit = shrinkVertically()
                        ) {
                            BottomNavigationCustom(navController = navController)
                        }
                    }
                ) {
                    Surface(color = MaterialTheme.colors.background) {
                        NavGraph(navHostController = navController)
                    }
                }
            }
        }
    }
}