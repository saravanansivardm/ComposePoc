package com.example.pocofdigivalapp.data.dashboard

import com.example.pocofdigivalapp.data.course.CourseItem
import com.google.gson.annotations.SerializedName

data class DashboardData(
    @SerializedName("sessions")
    val sessions: ArrayList<ScheduleItem?>?,
    @SerializedName("activities")
    val activities: ArrayList<ActivityListItem?>?,
    @SerializedName("courses")
    val courses: ArrayList<CourseItem>,
    @SerializedName("documents")
    val documents: ArrayList<DocumentItem?>?,
    @SerializedName("notificationCount")
    val notificationCount: Int?,
    @SerializedName("onGoingSchedule")
    val onGoingSchedule: ScheduleItem?,
)