package com.example.pocofdigivalapp.data.forgotpassword

import com.google.gson.annotations.SerializedName

data class ForgotPasswordCredentialModel(
    @SerializedName("user_type")
    val user_type: String?,
    @SerializedName("setMode")
    val setMode: String?,
    @SerializedName("newPassword")
    val newPassword: String?,
) {
}