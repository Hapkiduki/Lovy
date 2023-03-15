package com.hapkiduki.lovy.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    onProfileClick: () -> Unit,
    onMessagesClick: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hola desde el Home")
        Button(onClick = onProfileClick) {
            Text(text = "Ir al perfil")
        }
        Button(onClick = onMessagesClick) {
            Text(text = "Ir a la lista de mensajes")
        }
    }
}