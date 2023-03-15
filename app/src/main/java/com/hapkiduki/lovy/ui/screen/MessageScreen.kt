package com.hapkiduki.lovy.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MessageScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hola que se dice la rata Message")
    }
}