package com.example.pocofdigivalapp.data.signup

import com.google.gson.annotations.SerializedName

data class Verification(
    @SerializedName("document")
    val document: Boolean,
    @SerializedName("email")
    val email: Boolean,
    @SerializedName("face")
    val face: Boolean,
    @SerializedName("mobile")
    val mobile: Boolean,
    @SerializedName("password")
    val password: Boolean,
    @SerializedName("profile")
    val profile: Profile
)