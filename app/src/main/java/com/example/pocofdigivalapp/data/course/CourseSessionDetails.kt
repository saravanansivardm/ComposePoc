package com.example.pocofdigivalapp.data.course

import com.google.gson.annotations.SerializedName

data class CourseSessionDetails(
    @SerializedName("studentGroupName")
    val studentGroupName: String?,
    @SerializedName("totalSessions")
    val totalSessions: Int?,
    @SerializedName("completedSessions")
    val completedSessions: Int?,
    @SerializedName("pendingSessions")
    val pendingSessions: Int?,
    @SerializedName("courseSessions")
    val SessionCompletedList: ArrayList<SessionCompletedList?>,
)