package com.hapkiduki.lovy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.hapkiduki.lovy.navigation.LovyNavHost
import com.hapkiduki.lovy.navigation.authRoute
import com.hapkiduki.lovy.navigation.homeGraphRoutePattern
import com.hapkiduki.lovy.ui.AuthViewModel
import com.hapkiduki.lovy.ui.theme.LovyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            LovyTheme {
                Surface {
                    val navController = rememberNavController()
                    LovyNavHost(
                        navController = navController,
                        modifier = Modifier,
                        startDestination = getStartDestination()
                    )
                }
            }
        }
    }

    private fun getStartDestination(): String {
        return if (true) "home" else authRoute
    }
}




