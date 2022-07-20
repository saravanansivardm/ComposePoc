package com.example.pocofdigivalapp.data.course

import com.google.gson.annotations.SerializedName

data class SessionCompletedList(
    @SerializedName("deliveryName")
    val deliveryName: String?,
    @SerializedName("totalCount")
    val totalCount: Int?,
    @SerializedName("completedCount")
    val completedCount: Int?,
    @SerializedName("pendingCount")
    val pendingCount: Int?,
)