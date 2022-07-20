package com.example.notificationactcompose.data.studentinstitutionCalendar

import com.example.pocofdigivalapp.data.studentinstitutionCalendar.StudentInstitutionCalendarList
import com.google.gson.annotations.SerializedName

data class StudentInstitutionCalendarResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val dataList: ArrayList<StudentInstitutionCalendarList>,
)