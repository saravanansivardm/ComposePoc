package com.example.pocofdigivalapp.forgotpassword

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.data.forgotpassword.ForgotPasswordCredentialModel
import com.example.pocofdigivalapp.repository.AuthRepo
import com.example.pocofdigivalapp.utils.emptyString
import com.example.pocofdigivalapp.utils.isPasswordValid
import com.example.pocofdigivalapp.utils.rawString
import com.example.pocofdigivalapp.utils.resourceString
import kotlinx.coroutines.flow.*

class ForgotPasswordViewModel(
    private val authRepo: AuthRepo,
) : ViewModel(

) {
    var newPassword by mutableStateOf("")
        private set
    var confirmPassword by mutableStateOf("")
        private set

    private val viewModelState = MutableStateFlow(
        ForgotPasswordViewModelState(isLoading = false)
    )

    val forgotPasswordUiState = viewModelState
        .map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())

    fun onPasswordEntered(newPassword: String) {
        viewModelState.update { it.copy(isLoading = false) }
        this.newPassword = newPassword
    }

    fun onConfirmPasswordEntered(confirmPassword: String) {
        viewModelState.update { it.copy(isLoading = false) }
        this.confirmPassword = confirmPassword
    }

    private fun isPasswordValid(): Boolean {
        return newPassword.isPasswordValid()
    }

    private fun isConfirmPasswordValid(): Boolean {
        return confirmPassword.isPasswordValid()
    }

    fun onSaveAndContinueClicked() {
        if (!isPasswordValid() || !isConfirmPasswordValid()) {
            onErrorFound(emptyString())
        } else {
            viewModelState.update { it.copy(isLoading = true) }
            val response = authRepo.getForgotPassword()
//            val response = authRepo.getForgotPassword(forgotPasswordCredential())
            Log.e("response_forgot_logg", response.toString())
        }
    }

    private fun onErrorFound(message: String) {
        viewModelState.update { it.copy(isLoading = false) }
        val value = if (message.isEmpty()) resourceString(R.string.provide_valid_credentials)
        else rawString(message)
//        setMessage(value)
        Log.e("error_msg_log", value.toString())
    }

    fun onBackPressed() {
        Log.e("backpress_clicked_log", "truee")
    }

    private fun forgotPasswordCredential() = ForgotPasswordCredentialModel(
        user_type = "staff",
        setMode = newPassword,
        newPassword = confirmPassword,
    )
}

sealed class ForgotPasswordState {
    object Ideal : ForgotPasswordState()
    object Loading : ForgotPasswordState()
}

data class ForgotPasswordViewModelState(
    val isLoading: Boolean = false,
    val isLogoClicked: Boolean = false,
) {
    fun toUiState(): ForgotPasswordState {
        return when {
            isLoading -> ForgotPasswordState.Loading
            else -> ForgotPasswordState.Ideal
        }
    }
}