package com.example.pocofdigivalapp.data.userdetailsget


import com.google.gson.annotations.SerializedName

data class UserDetailsGetResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String
)