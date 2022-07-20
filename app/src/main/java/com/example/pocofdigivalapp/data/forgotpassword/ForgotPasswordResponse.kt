package com.example.pocofdigivalapp.data.forgotpassword

import com.google.gson.annotations.SerializedName

data class ForgotPasswordResponse(
    @SerializedName("data")
    val data: Data,
    @SerializedName("message")
    val message: String
)