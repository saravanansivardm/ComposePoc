package com.example.pocofdigivalapp.forgotpassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun ForgotPasswordRoute(viewModel: ForgotPasswordViewModel) {
    val uiState by viewModel.forgotPasswordUiState.collectAsState()
    when (uiState) {
        is ForgotPasswordState.Ideal -> {
            ForgotPasswordScreen(
                newPassword = viewModel.newPassword,
                onPasswordChanged = { viewModel.onPasswordEntered(it) },
                confirmPassword = viewModel.confirmPassword,
                onConfirmPasswordChanged = { viewModel.onConfirmPasswordEntered(it) },
                onButtonClick = { viewModel.onSaveAndContinueClicked() },
                onBackPressClick = { viewModel.onBackPressed() },
                requestInProgress = false,
            )
        }
        is ForgotPasswordState.Loading -> {
            ForgotPasswordScreen(
                newPassword = viewModel.newPassword,
                onPasswordChanged = { viewModel.onPasswordEntered(it) },
                confirmPassword = viewModel.confirmPassword,
                onConfirmPasswordChanged = { viewModel.onConfirmPasswordEntered(it) },
                onButtonClick = { viewModel.onSaveAndContinueClicked() },
                onBackPressClick = { viewModel.onBackPressed() },
                requestInProgress = true,
            )
        }
    }
}
