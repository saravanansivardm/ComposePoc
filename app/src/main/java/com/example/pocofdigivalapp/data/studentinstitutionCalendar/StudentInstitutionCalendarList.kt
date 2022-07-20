package com.example.pocofdigivalapp.data.studentinstitutionCalendar

import com.google.gson.annotations.SerializedName

data class StudentInstitutionCalendarList(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("calendar_name")
    val calendarName: String?,
)