package com.hapkiduki.lovy.ui.components

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.google.android.gms.auth.api.signin.GoogleSignIn

@Composable
fun GoogleButton(
    onSuccess: (String) -> Unit,
    intent: Intent
) {
    val googleSignInLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            val idToken = task.result?.idToken
            if (idToken != null) {
                Log.i("Login", "GoogleButton: $idToken")
                onSuccess(idToken)
            }
        } else {
            // Handle error
            Log.i("Login", "GoogleButton: Error al logear")
        }
    }

    Button(onClick = {
        googleSignInLauncher.launch(intent)
    }) {
        Text(text = "Iniciar sesión con Google")
    }
}