package com.example.pocofdigivalapp.data.basicdetailupdate


import com.google.gson.annotations.SerializedName

data class BasicDetailsUpdateResponse(
    @SerializedName("data")
    val data: Data,
    @SerializedName("message")
    val message: String
)