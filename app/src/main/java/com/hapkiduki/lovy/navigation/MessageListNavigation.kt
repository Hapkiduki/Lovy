package com.hapkiduki.lovy.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.hapkiduki.lovy.ui.screen.LoginScreen
import com.hapkiduki.lovy.ui.screen.MessageListRoute

private const val messageListGraphRoutePattern = "message_list_graph"
const val messageListRoute = "message_list_route"

fun NavController.navigateToMessageListGraph(navOptions: NavOptions? = null) {
    this.navigate(messageListGraphRoutePattern, navOptions)
}

fun NavGraphBuilder.messageListGraph(
    onMessageCLick: (String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = messageListGraphRoutePattern,
        startDestination = messageListRoute
    ) {
        composable(
            route = messageListRoute,
        ) {
            MessageListRoute(onMessageClick = onMessageCLick)
        }
        nestedGraphs()
    }
}