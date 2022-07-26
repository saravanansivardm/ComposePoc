package com.example.pocofdigivalapp.repository

import com.example.pocofdigivalapp.data.forgotpassword.ForgotPasswordCredentialModel
import com.example.pocofdigivalapp.data.forgotpassword.ForgotPasswordResponse
import com.example.pocofdigivalapp.data.signup.CredentialModel
import com.example.pocofdigivalapp.data.signup.SignupResponse
import com.example.pocofdigivalapp.utils.handleResponse

class NewAuthApiManager(private val authService: NewAuthService) {

    suspend fun login(credential: CredentialModel): Response<SignupResponse?> {
        return handleResponse { authService.login(credential) }
    }

    suspend fun setNewPassword(forgotPasswordCredentialModel: ForgotPasswordCredentialModel): Response<ForgotPasswordResponse?> {
        return handleResponse { authService.setNewPassword(forgotPasswordCredentialModel) }
    }
}