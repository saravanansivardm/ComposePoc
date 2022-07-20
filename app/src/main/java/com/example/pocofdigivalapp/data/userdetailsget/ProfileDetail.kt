package com.example.pocofdigivalapp.data.userdetailsget


import com.google.gson.annotations.SerializedName

data class ProfileDetail(
    @SerializedName("_id")
    val id: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isCompulsary")
    val isCompulsary: Boolean,
    @SerializedName("isMandatory")
    val isMandatory: Boolean,
    @SerializedName("name")
    val name: String
)