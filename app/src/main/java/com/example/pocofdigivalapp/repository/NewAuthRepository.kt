package com.example.pocofdigivalapp.repository

import android.content.Context
import com.example.pocofdigivalapp.data.forgotpassword.ForgotPasswordCredentialModel
import com.example.pocofdigivalapp.data.forgotpassword.ForgotPasswordResponse
import com.example.pocofdigivalapp.data.signup.CredentialModel
import com.example.pocofdigivalapp.data.signup.SignupResponse
import com.example.pocofdigivalapp.utils.PreferenceManager

class NewAuthRepository(
    private val context: Context,
    private val apiManager: NewAuthApiManager,
    private val preferenceManager: PreferenceManager,
) {
    suspend fun login(credential: CredentialModel): SignupResponse? {
        return mapLogin(apiManager.login(credential), preferenceManager, context)
    }

    suspend fun setNewPassword(
        forgotPasswordCredentials: ForgotPasswordCredentialModel
    ): ForgotPasswordResponse? {
        return mapChangePassword(apiManager.setNewPassword(forgotPasswordCredentials), context)
    }
}