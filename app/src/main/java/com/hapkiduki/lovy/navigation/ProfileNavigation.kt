package com.hapkiduki.lovy.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hapkiduki.lovy.ui.screen.LoginScreen
import com.hapkiduki.lovy.ui.screen.ProfileScreen

const val profileRoute = "profile_route"

fun NavController.navigateToProfile(navOptions: NavOptions? = null) {
    this.navigate(profileRoute, navOptions)
}

fun NavGraphBuilder.profileScreen(
    onBackClick: () -> Unit
) {
    composable(route = profileRoute) {
        ProfileScreen()
    }
}