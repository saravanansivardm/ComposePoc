package com.example.pocofdigivalapp.data.signup

import com.google.gson.annotations.SerializedName

data class SignupResponse(
    @SerializedName("data")
    val data: Data,
    @SerializedName("message")
    val message: String
)