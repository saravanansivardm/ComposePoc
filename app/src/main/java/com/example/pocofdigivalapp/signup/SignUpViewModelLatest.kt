package com.example.pocofdigivalapp.signup

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.data.signup.CredentialModel
import com.example.pocofdigivalapp.data.signup.SignupResponse
import com.example.pocofdigivalapp.repository.NewAuthRepository
import com.example.pocofdigivalapp.utils.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SignUpViewModelLatest(
    private val authRepo: NewAuthRepository,
) : ViewModel() {

    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    private val viewModelState = MutableStateFlow(
        SignUpStateViewModelState(isLoading = false)
    )

    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())

    fun onEmailEntered(emailId: String) {
        //_loginState.value = SignUpState.Ideal
        viewModelState.update { it.copy(isLoading = false) }
        email = emailId
    }

    fun onPasswordEntered(password: String) {
        //_loginState.value = SignUpState.Ideal
        viewModelState.update { it.copy(isLoading = false) }
        this.password = password
    }

    private fun isEmailValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty()
    }

    private fun isPasswordValid(): Boolean {
        return password.isPasswordValid()
    }

    fun onSubmitClicked() {
        viewModelScope.launch {
            if (!isEmailValid() || !isPasswordValid()) {
                onErrorFound(emptyString())
            } else {
                viewModelState.update { it.copy(isLoading = true) }
                val response = authRepo.login(getCredentialModel())
                if (response?.message.equals(
                        "SIGNED_IN_SUCCESSFULLY",
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

    private fun getUserCredential(loginResponse: SignupResponse?) {
        /*val response = authRepo.getUserDetails(
            UserDetailsRequest(
                id = loginResponse?.data?._id,
                deviceType = Constants.DEVICE_TYPE,
                fcmToken = fcmToken
            )
        )*/
    }
    private fun getCredentialModel() =
        CredentialModel(
            email = email,
            password = password,
        )

    private fun onErrorFound(message: String) {
        viewModelState.update { it.copy(isLoading = false) }
        val value = if (message.isEmpty()) resourceString(R.string.provide_valid_credentials)
        else rawString(message)
//        setMessage(value)
    }


}

sealed class SignUpState {
    object Ideal : SignUpState()
    object Loading : SignUpState()
    object DevMode : SignUpState()
}

data class SignUpStateViewModelState(
    val isLoading: Boolean = false,
    val isLogoClicked: Boolean = false,
) {
    fun toUiState(): SignUpState {
        return when {
            isLogoClicked -> SignUpState.DevMode
            isLoading -> SignUpState.Loading
            else -> SignUpState.Ideal
        }
    }
}