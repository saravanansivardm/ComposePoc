package com.example.pocofdigivalapp.data.staff

import com.google.gson.annotations.SerializedName

data class ScheduleStaffItem(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("staff_name")
    val staffName: StaffNameModel?,
    @SerializedName("_staff_id")
    val staffId: String?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("mode")
    val mode: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("academicId")
    val academicId: String?
)