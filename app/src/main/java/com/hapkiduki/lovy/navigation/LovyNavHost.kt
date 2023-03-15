package com.hapkiduki.lovy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hapkiduki.lovy.ui.screen.MainScreen

@Composable
fun LovyNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        route = "root"
    ) {
        authScreen()
        composable(
            route = "home"
        ) {
            MainScreen(navController)
        }
        messageListGraph(
            onMessageCLick = { messageId ->
                navController.navigateToMessage(messageId)
            },
            nestedGraphs = {
                messageScreen(
                    onBackClick = navController::popBackStack
                )
            }
        )
    }
}

@Composable
fun HomeNavHost(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = homeGraphRoutePattern,
        route = "root"
    ) {
        homeGraph(
            onProfileClick = navController::navigateToProfile,
            onMessageListClick = navController::navigateToMessageListGraph,
            nestedGraphs = {
                profileScreen(
                    onBackClick = navController::popBackStack
                )
            }
        )
    }
}



