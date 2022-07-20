package com.example.pocofdigivalapp.data.userdetailsget


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("labels")
    val labels: Labels,
    @SerializedName("userData")
    val userData: UserData
)