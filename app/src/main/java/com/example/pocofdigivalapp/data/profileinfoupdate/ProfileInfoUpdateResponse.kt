package com.example.pocofdigivalapp.data.profileinfoupdate


import com.google.gson.annotations.SerializedName

data class ProfileInfoUpdateResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String
)