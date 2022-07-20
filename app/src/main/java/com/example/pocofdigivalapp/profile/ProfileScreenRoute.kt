package com.example.pocofdigivalapp.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.pocofdigivalapp.signup.LoginState

@Composable
fun ProfileScreenRoute(profileScreenViewModel: ProfileScreenViewModel) {
    val uiState by profileScreenViewModel.uiState.collectAsState()
    when (uiState) {
        is LoginState.Ideal -> {
            ProfileScreen(
                onButtonClick = { profileScreenViewModel.onSubmitClicked() },
                requestInProgress = false,
            )
        }
        is LoginState.Loading -> {
            ProfileScreen(
                onButtonClick = { profileScreenViewModel.onSubmitClicked() },
                requestInProgress = true,
            )
        }
    }
}