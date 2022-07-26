package com.example.pocofdigivalapp.data.basicdetailupdate


import com.google.gson.annotations.SerializedName

data class Test(
    @SerializedName("data")
    val `data`: BasicDetailsData,
    @SerializedName("setMode")
    val setMode: String,
    @SerializedName("user_type")
    val userType: String
)