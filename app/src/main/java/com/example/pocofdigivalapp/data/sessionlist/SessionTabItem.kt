package com.example.pocofdigivalapp.data.sessionlist

import com.google.gson.annotations.SerializedName

data class SessionTabItem(
    //Fields used in schedule item
    @SerializedName("name")
    val name: String?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("type")
    val type: String?,
)
