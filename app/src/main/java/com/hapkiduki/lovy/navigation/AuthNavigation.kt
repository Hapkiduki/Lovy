package com.hapkiduki.lovy.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hapkiduki.lovy.ui.screen.LoginScreen

const val authRoute = "auth_route"

fun NavController.navigateToAuth(navOptions: NavOptions? = null) {
    this.navigate(authRoute, navOptions)
}

fun NavGraphBuilder.authScreen() {
    composable(route = authRoute) {
        LoginScreen()
    }
}