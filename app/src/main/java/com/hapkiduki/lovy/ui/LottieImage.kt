package com.hapkiduki.lovy.ui

import androidx.compose.runtime.Composable

enum class LottieImage(
    val animation: @Composable () -> Unit
) {
    Meditation(
        animation = {
            com.hapkiduki.lovy.ui.components.LottieFile(lottie = com.hapkiduki.lovy.R.raw.meditation)
        }
    ),
    Friends(
        animation = {
            com.hapkiduki.lovy.ui.components.LottieFile(lottie = com.hapkiduki.lovy.R.raw.friends)
        }
    ),
}