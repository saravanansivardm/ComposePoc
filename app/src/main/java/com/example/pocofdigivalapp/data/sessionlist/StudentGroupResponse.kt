package com.example.pocofdigivalapp.data.sessionlist

import com.google.gson.annotations.SerializedName

data class StudentGroupResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("message")
    val message: String?,
)
