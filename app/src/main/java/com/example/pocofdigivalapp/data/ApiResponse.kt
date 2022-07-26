package com.example.pocofdigivalapp.data

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: Any?,
)