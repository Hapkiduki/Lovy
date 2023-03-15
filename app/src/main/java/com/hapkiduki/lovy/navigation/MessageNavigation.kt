package com.hapkiduki.lovy.navigation

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hapkiduki.lovy.common.decoder.StringDecoder
import com.hapkiduki.lovy.ui.screen.MessageScreen

internal const val messageIdArg = "messageId"

internal class MessageArgs(val messageId: String) {
    constructor(savedStateHandle: SavedStateHandle, stringDecoder: StringDecoder) :
            this(stringDecoder.decodeString(checkNotNull(savedStateHandle[messageIdArg])))
}

fun NavController.navigateToMessage(messageId: String) {
    val encodedId = Uri.encode(messageId)
    this.navigate("message_route/$encodedId")
}

fun NavGraphBuilder.messageScreen(
    onBackClick: () -> Unit
) {
    composable(
        route = "message_route/{$messageIdArg}",
        arguments = listOf(
            navArgument(messageIdArg) { type = NavType.StringType }
        )
    ) {
        MessageScreen()
    }
}