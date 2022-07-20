package com.example.pocofdigivalapp.data.signup

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("password")
    val password: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("user_type")
    val user_type: String,
    @SerializedName("verification")
    val verification: Verification
)