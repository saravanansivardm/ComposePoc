package com.example.pocofdigivalapp.data.sessionlist

import com.google.gson.annotations.SerializedName

data class SessionForUser(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("_session_id")
    val sessionId: String?,
    @SerializedName("delivery_symbol")
    val deliverySymbol: String?,
    @SerializedName("session_type")
    val sessionType: String?,
    @SerializedName("session_topic")
    val sessionTopic: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("s_no")
    val sNo: Int?,
    @SerializedName("delivery_no")
    val deliveryNo: Int?,
)