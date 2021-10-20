package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.bottom_navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.Screen
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_characters.content.BottomNavigationHeight

val bottomNavigationScreens = listOf(
    Screen.Characters,
    Screen.Episodes,
)

@Composable
fun BottomNavigationCustom(
    navController: NavController,
) {
    BottomNavigation(modifier = Modifier.height(height = BottomNavigationHeight)) {
        // importar como um estado, assim o compose reage as mudanças
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        bottomNavigationScreens.forEachIndexed { index, screen ->
            BottomNavigationItem(
                icon = {
                    BottomNavigationIcon(screen = screen)
                },
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true,
                label = {
                    BottomNavigationLabel(screen = screen)
                },
                onClick = { // da propria documentacao
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun BottomNavigationIcon(screen: Screen) {
    Icon(
        imageVector = screen.iconId ?: Icons.Rounded.Home,
        contentDescription = stringResource(id = screen.stringId),
        modifier = Modifier.size(20.dp)
    )
}

@Composable
fun BottomNavigationLabel(screen: Screen) {
    Text(text = stringResource(id = screen.stringId), fontSize = 12.sp)
}