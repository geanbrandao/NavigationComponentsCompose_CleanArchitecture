package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.NavArgsKeys.CHARACTER_NAME
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.Screen
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_character_details.CharacterDetailsScreen
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_characters.content.CharacterScreen
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_episodes.content.EpisodesScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
) {
    NavHost(navController = navHostController, startDestination = Screen.Characters.route) {
        composable(
            route = Screen.Characters.route,
        ) {
            CharacterScreen(navController = navHostController)
        }
        composable(route = Screen.Episodes.route) {
            EpisodesScreen()
        }
        composable(
            route = Screen.CharactersDetails.route + "/{$CHARACTER_NAME}",
            arguments = listOf(
                navArgument(CHARACTER_NAME) {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) {
            CharacterDetailsScreen(
                characterName = it.arguments?.getString(CHARACTER_NAME)!!
            ) {
                navHostController.navigateUp()
            }
        }
    }
}