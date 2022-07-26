package com.example.pocofdigivalapp.data.signup

import com.google.gson.annotations.SerializedName

data class SignupResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: Data?
)