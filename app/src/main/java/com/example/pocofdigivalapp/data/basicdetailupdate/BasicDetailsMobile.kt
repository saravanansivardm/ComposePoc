package com.example.pocofdigivalapp.data.basicdetailupdate


import com.google.gson.annotations.SerializedName

data class BasicDetailsMobile(
    @SerializedName("code")
    val code: String,
    @SerializedName("no")
    val no: String
)