package com.hapkiduki.lovy.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hapkiduki.lovy.ui.screen.HomeScreen

const val homeGraphRoutePattern = "home_graph"
const val homeNavigationRoute = "home_route"

fun NavController.navigateToHomeGraph(navOptions: NavOptions? = null) {
    this.navigate(homeGraphRoutePattern, navOptions)
}

fun NavGraphBuilder.homeGraph(
    onProfileClick: () -> Unit,
    onMessageListClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = homeGraphRoutePattern,
        startDestination = homeNavigationRoute
    ) {
        composable(route = homeNavigationRoute) {
            HomeScreen(
                onProfileClick = onProfileClick,
                onMessagesClick = onMessageListClick
            )
        }
        nestedGraphs()
    }
}