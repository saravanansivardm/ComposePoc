package com.example.pocofdigivalapp.forgotpassword

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.data.forgotpassword.ForgotPasswordCredentialModel
import com.example.pocofdigivalapp.data.forgotpassword.ForgotPasswordResponse
import com.example.pocofdigivalapp.data.signup.CredentialModel
import com.example.pocofdigivalapp.data.signup.SignupResponse
import com.example.pocofdigivalapp.repository.AuthRepo
import com.example.pocofdigivalapp.repository.NewAuthRepository
import com.example.pocofdigivalapp.utils.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ForgotPasswordViewModelLatest(
    private val authRepo: NewAuthRepository,
) : ViewModel(

) {
    var newPassword by mutableStateOf("")
        private set
    var confirmPassword by mutableStateOf("")
        private set

    private val viewModelState = MutableStateFlow(
        ForgotPasswordUiState(isLoading = false)
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
        viewModelScope.launch {
            if (!isPasswordValid() || !isConfirmPasswordValid()) {
                onErrorFound(emptyString())
            } else {
                viewModelState.update { it.copy(isLoading = true) }
                val response = authRepo.setNewPassword(forgotPasswordCredentialModel())
                if (response?.message.equals(
                        "UPDATED_SUCCESSFULLY",
                        ignoreCase = false
                    )
                ) {
                    getUserCredential(response)
                } else {
                    onErrorFound(response?.message.valueOrDefault())
                }
            }
        }
    }

    private fun getUserCredential(forgotPasswordResponse: ForgotPasswordResponse?) {
        /*val response = authRepo.getUserDetails(
            UserDetailsRequest(
                id = loginResponse?.data?._id,
                deviceType = Constants.DEVICE_TYPE,
                fcmToken = fcmToken
            )
        )*/
    }

    private fun forgotPasswordCredentialModel() = ForgotPasswordCredentialModel(
        user_type = "staff",
        setMode = newPassword,
        newPassword = confirmPassword,
    )

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

}

sealed class ForgotPasswordStateLatest {
    object Ideal : ForgotPasswordStateLatest()
    object Loading : ForgotPasswordStateLatest()
}

data class ForgotPasswordUiState(
    val isLoading: Boolean = false,
    val isLogoClicked: Boolean = false,
) {
    fun toUiState(): ForgotPasswordStateLatest {
        return when {
            isLoading -> ForgotPasswordStateLatest.Loading
            else -> ForgotPasswordStateLatest.Ideal
        }
    }
}