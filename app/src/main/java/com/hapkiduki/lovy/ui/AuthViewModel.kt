package com.hapkiduki.lovy.ui

import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseUser
import com.hapkiduki.lovy.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val googleSignInClient: GoogleSignInClient
) : ViewModel() {
    private val _user = MutableStateFlow<FirebaseUser?>(null)
    val user: StateFlow<FirebaseUser?>
        get() = _user

    private val _signInError = MutableStateFlow<String?>(null)
    val signInError: StateFlow<String?>
        get() = _signInError

    init {
        val currentUser = authRepository.getCurrentUser()
        if (currentUser != null) {
            _user.value = currentUser
        }
    }

    fun getGoogleSignInIntent(): Intent {
        return googleSignInClient.signInIntent
    }

    fun signingWithGoogle(idToken: String) {
        viewModelScope.launch {
            try {
                val userResponse = authRepository.signInWithGoogle(idToken).await()
                _user.value = userResponse.user
            } catch (e: Exception) {

                _signInError.value = e.message

            }
        }
    }

    fun signOut() {
        viewModelScope.launch {
            authRepository.signOut()
            _user.value = null

        }
    }
}