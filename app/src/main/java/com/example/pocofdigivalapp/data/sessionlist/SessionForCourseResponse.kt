package com.example.pocofdigivalapp.data.sessionlist

import com.example.pocofdigivalapp.data.sessionlist.SessionForCourse
import com.google.gson.annotations.SerializedName

data class SessionForCourseResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val sessionList: ArrayList<SessionForCourse?>?,
)