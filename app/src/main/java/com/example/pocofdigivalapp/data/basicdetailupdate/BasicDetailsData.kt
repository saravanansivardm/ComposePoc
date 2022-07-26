package com.example.pocofdigivalapp.data.basicdetailupdate


import com.google.gson.annotations.SerializedName

data class BasicDetailsData(
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("mobile")
    val mobile: BasicDetailsMobile,
    @SerializedName("name")
    val name: BasicDetailsName
)