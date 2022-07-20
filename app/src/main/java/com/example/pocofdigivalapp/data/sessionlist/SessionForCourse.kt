package com.example.pocofdigivalapp.data.sessionlist

import com.google.gson.annotations.SerializedName

data class SessionForCourse(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("title")
    val title: String?,
)