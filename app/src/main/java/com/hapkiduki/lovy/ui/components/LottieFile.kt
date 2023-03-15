package com.hapkiduki.lovy.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.hapkiduki.lovy.R

@Composable
fun LottieFile(
    lottie: Int
) {
    val spec = LottieCompositionSpec.RawRes(lottie)
    val composition by rememberLottieComposition(spec = spec)
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        speed = 1f
    )
}

@Composable
@Preview(showBackground = true)
fun LottieFilePreview() {

    Box(modifier = Modifier.fillMaxSize()) {
        LottieFile(lottie = R.raw.meditation)
    }
}
