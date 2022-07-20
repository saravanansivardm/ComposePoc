package com.example.pocofdigivalapp.data.userdetailsget


import com.google.gson.annotations.SerializedName

data class BoosterDetail(
    @SerializedName("days")
    val days: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("labelName")
    val labelName: String
)