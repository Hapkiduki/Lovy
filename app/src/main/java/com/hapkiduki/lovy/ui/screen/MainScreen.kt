package com.hapkiduki.lovy.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hapkiduki.lovy.navigation.HomeNavHost

@Composable
fun MainScreen(navController: NavHostController?) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Pantallas nested")

        HomeNavHost(navController =  rememberNavController())
    }
}