package com.hapkiduki.lovy.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.sin

@Composable
@Preview
fun CircleView() {
    val waveProgress = remember {
        Animatable(initialValue = 0f)
    }


    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(
            color = Color.Blue,
            center = Offset(size.width / 2, size.height / 2),
            radius = size.width / 2,
            style = Stroke(width = 4.dp.toPx())
        )

        val waveCount = 5
        val waveHeight = 20.dp.toPx()
        val waveWidth = 50.dp.toPx()
        val waveSpacing = 10.dp.toPx()
        val centerX = size.width / 2
        val centerY = size.height / 2

        for (i in 0 until waveCount) {
            val waveProgressOffset = (i.toFloat() / waveCount) + waveProgress.value
            val yOffset = waveHeight * sin(waveProgressOffset * PI.toFloat() * 2)
            val startX =
                centerX - (waveCount / 2f * (waveWidth + waveSpacing)) + i * (waveWidth + waveSpacing)
            val endX = startX + waveWidth

            drawLine(
                color = Color.Yellow,
                start = Offset(startX, centerY + yOffset),
                end = Offset(endX, centerY + yOffset),
                strokeWidth = 4.dp.toPx()
            )
        }
    }



    LaunchedEffect(key1 = waveProgress) {
        waveProgress.animateTo(
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 1000,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }
}
