package com.hapkiduki.lovy.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun MessageListRoute(
    onMessageClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    MessageListScreen()
}



@Composable
fun MessageListScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hola que se dice la rata MessageList")
    }
}