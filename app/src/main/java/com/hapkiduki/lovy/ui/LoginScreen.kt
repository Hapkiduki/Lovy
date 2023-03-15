package com.hapkiduki.lovy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hapkiduki.lovy.ui.components.GoogleButton
import com.hapkiduki.lovy.ui.components.LottieFile
import com.hapkiduki.lovy.R

@Composable
fun LoginScreen(
    viewModel: AuthViewModel
) {
    val signInError by viewModel.signInError.collectAsState()

    val user by viewModel.user.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {


        Image(
            painterResource(id = R.drawable.lovy),
            contentDescription = "Logo",
            modifier = Modifier.size(250.dp)
        )
        Box(modifier = Modifier.size(200.dp)) {
            //LottieFile()
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Iniciar sesión",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
            IconButton(onClick = viewModel::signOut) {
                Icon(
                    imageVector = Icons.Filled.ExitToApp,
                    contentDescription = "Sign out"
                )
            }
        }
        GoogleButton(
            intent = viewModel.getGoogleSignInIntent(),
            onSuccess = viewModel::signingWithGoogle
        )

        if (user != null) {
            Text(text = "Bienvenido ${user!!.displayName}")
            Text(text = "${user!!.email}")
        }

        if (signInError != null) {
            Text(
                text = signInError!!,
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }

}