package com.example.pocofdigivalapp.signup

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.data.signup.SignupCredentialModel
import com.example.pocofdigivalapp.repository.AuthRepo
import com.example.pocofdigivalapp.utils.emptyString
import com.example.pocofdigivalapp.utils.isPasswordValid
import com.example.pocofdigivalapp.utils.rawString
import com.example.pocofdigivalapp.utils.resourceString
import kotlinx.coroutines.flow.*

class SignUpViewModel(private val authRepo: AuthRepo) : ViewModel() {
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    private val viewModelState = MutableStateFlow(
        LoginViewModelState(isLoading = false)
    )

    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())

    fun goToLogin() {
        Log.e("loginclicked", "true")
    }

    fun onEmailEntered(emailId: String) {
        //_loginState.value = LoginState.Ideal
        viewModelState.update { it.copy(isLoading = false) }
        email = emailId
    }

    fun onPasswordEntered(password: String) {
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
        if (email.isEmpty()) {
            onErrorFound(emptyString())
        } else if (password.isEmpty()) {
            onErrorFound(emptyString())
        } else if (!isEmailValid() || !isPasswordValid()) {
            onErrorFound(emptyString())
        } else {
            viewModelState.update { it.copy(isLoading = true) }
            val response = authRepo.getSignUp()
//            val response = authRepo.getSignUp(signupCredential())
            Log.e("response_logg", response.toString())
            /*when (response) {
                true -> getUserCredential(response)
                else -> onErrorFound(response?.message.valueOrDefault())
            }*/
        }
    }

    private fun onErrorFound(message: String) {
        viewModelState.update { it.copy(isLoading = false) }
        val value = if (message.isEmpty()) resourceString(R.string.provide_valid_credentials)
        else rawString(message)
//        setMessage(value)
        Log.e("error_msg_log", value.toString())
    }

    private fun signupCredential() = SignupCredentialModel(
        email = email,
        password = password
    )
}

sealed class LoginState {
    object Ideal : LoginState()
    object Loading : LoginState()
}

data class LoginViewModelState(
    val isLoading: Boolean = false,
    val isLogoClicked: Boolean = false,
) {
    fun toUiState(): LoginState {
        return when {
            isLoading -> LoginState.Loading
            else -> LoginState.Ideal
        }
    }
}