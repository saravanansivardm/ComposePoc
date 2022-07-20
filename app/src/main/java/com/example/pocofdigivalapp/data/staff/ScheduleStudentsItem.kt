package com.example.pocofdigivalapp.data.staff

import com.google.gson.annotations.SerializedName

data class ScheduleStudentsItem(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("name")
    val name: StaffNameModel?,
    @SerializedName("user_id")
    val userId: String?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("mode")
    val mode: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("leave")
    val leave: String?,
    @SerializedName("percentage")
    val percentage: String?,
    @SerializedName("duration")
    val duration: String?,
)