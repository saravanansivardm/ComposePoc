package com.example.pocofdigivalapp.data.sessionlist

import com.example.pocofdigivalapp.data.sessionlist.MergeSessionData
import com.google.gson.annotations.SerializedName

data class SessionItem(
    //Fields used in schedule item
    @SerializedName("_session_id")
    val sessionId: String?,
    @SerializedName("delivery_no")
    val deliveryNo: Int?,
    @SerializedName("delivery_symbol")
    val deliverySymbol: String?,
    @SerializedName("session_type")
    val sessionType: String?,
    @SerializedName("mode")
    val mode: String?,
    @SerializedName("session_topic")
    val sessionTopic: String?,
    @SerializedName("merge_status")
    val mergeStatus: Boolean?,
    @SerializedName("year")
    val year: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("feedback")
    val feedback: String?,
    @SerializedName("program_name")
    val programName: String?,
    @SerializedName("level")
    val level: String?,
    @SerializedName("merge_with")
    var mergeWith: ArrayList<MergeSessionData?>?,
    @SerializedName("s_no")
    val sNo: Int?,
    @SerializedName("documentCount")
    val documentCount: Int?,
    @SerializedName("activityCount")
    val activityCount: Int?,

    )
