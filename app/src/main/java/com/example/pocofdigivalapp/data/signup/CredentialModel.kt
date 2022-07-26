package com.example.pocofdigivalapp.data.signup

import com.google.gson.annotations.SerializedName

data class CredentialModel(
    @SerializedName("email")
    val email: String?,
    @SerializedName("password")
    val password: String?,
)
