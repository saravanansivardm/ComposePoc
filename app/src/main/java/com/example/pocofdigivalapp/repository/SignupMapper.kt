package com.example.pocofdigivalapp.repository

import android.content.Context
import com.example.pocofdigivalapp.data.forgotpassword.ForgotPasswordResponse
import com.example.pocofdigivalapp.data.signup.SignupResponse
import com.example.pocofdigivalapp.utils.PreferenceManager

fun mapLogin(
    response: Response<SignupResponse?>,
    preferenceManager: PreferenceManager,
    context: Context
): SignupResponse? {
    return when (response) {
        is Response.Success -> {
            try {
                val data = response.data
                val loginData = data?.data
//                preferenceManager.setStudentId(loginData?.studentId)
//                preferenceManager.setStudentEmailId(loginData?.email)
            } catch (exp: Exception) {
            }
            response.data
        }
        is Response.Failure -> {
            preferenceManager.setUserLoggedIn(false)
            SignupResponse(500, false, response.error.msg.en, null)
        }
        is Response.NoNetwork -> SignupResponse(
            500,
            false,
            context.getString(response.messageId),
            null
        )
    }
}

fun mapChangePassword(
    response: Response<ForgotPasswordResponse?>,
    context: Context
): ForgotPasswordResponse? {
    return when (response) {
        is Response.Success -> response.data
        is Response.Failure -> ForgotPasswordResponse(404, false, response.error.msg.en, null)
        is Response.NoNetwork -> ForgotPasswordResponse(
            404,
            false,
            context.getString(response.messageId),
            null
        )
    }
}