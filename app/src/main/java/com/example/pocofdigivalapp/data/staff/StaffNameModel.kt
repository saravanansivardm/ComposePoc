package com.example.pocofdigivalapp.data.staff

import com.google.gson.annotations.SerializedName

data class StaffNameModel(
    @SerializedName("first")
    val firstName: String?,
    @SerializedName("last")
    val lastName: String?,
    @SerializedName("middle")
    val middle: String,

    @SerializedName("family")
    val family: String,
)