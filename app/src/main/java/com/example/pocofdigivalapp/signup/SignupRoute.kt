package com.example.pocofdigivalapp.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun SignupRoute(viewModel: SignUpViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        is LoginState.Ideal -> {
            SignupScreen(
                email = viewModel.email,
                onEmailChanged = { viewModel.onEmailEntered(it) },
                password = viewModel.password,
                onPasswordChanged = { viewModel.onPasswordEntered(it) },
                onButtonClick = { viewModel.onSubmitClicked() },
                onForgotPasswordClick = { viewModel.goToLogin() },
                requestInProgress = false,
            )
        }
        is LoginState.Loading -> {
            SignupScreen(
                email = viewModel.email,
                onEmailChanged = { viewModel.onEmailEntered(it) },
                password = viewModel.password,
                onPasswordChanged = { viewModel.onPasswordEntered(it) },
                onButtonClick = { viewModel.onSubmitClicked() },
                onForgotPasswordClick = { viewModel.goToLogin() },
                requestInProgress = true,
            )
        }
        else -> {}
    }
}