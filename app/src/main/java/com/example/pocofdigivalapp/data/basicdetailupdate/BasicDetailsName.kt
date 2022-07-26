package com.example.pocofdigivalapp.data.basicdetailupdate


import com.google.gson.annotations.SerializedName

data class BasicDetailsName(
    @SerializedName("first")
    val first: String?,
    @SerializedName("last")
    val last: String?,
    @SerializedName("middle")
    val middle: String?,
    @SerializedName("family")
    val family: String?
)