package com.hapkiduki.lovy.ui.theme

import android.app.Activity
import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    primary = LovyDarkPurple,
    secondary = LovyPurple,
    tertiary = LovyDarkRed,
    tertiaryContainer = LovyRed,
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onPrimary = LovyWhite,
    onSecondary = LovyWhite,
    onBackground = LovyWhite,
    onSurface = LovyGray
)

private val LightColorScheme = lightColorScheme(
    primary = LovyPurple,
    secondary = LovyDarkPurple,
    tertiary = LovyRed,
    tertiaryContainer = LovyDarkRed,
    background = LovyWhite,
    surface = LovyWhite,
    onPrimary = LovyWhite,
    onSecondary = LovyWhite,
    onBackground = LovyGray,
    onSurface = LovyGray

)


@Composable
fun LovyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        androidTheme -> if (darkTheme) darkColorScheme() else lightColorScheme()
        !disableDynamicTheming && supportsDynamicTheming() -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S