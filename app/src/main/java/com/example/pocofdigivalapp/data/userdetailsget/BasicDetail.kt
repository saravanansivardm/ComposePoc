package com.example.pocofdigivalapp.data.userdetailsget


import com.google.gson.annotations.SerializedName

data class BasicDetail(
    @SerializedName("allowToChange")
    val allowToChange: Boolean,
    @SerializedName("defaultValue")
    val defaultValue: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isCompulsary")
    val isCompulsary: Boolean,
    @SerializedName("isMandatory")
    val isMandatory: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("translatedInput")
    val translatedInput: String
)