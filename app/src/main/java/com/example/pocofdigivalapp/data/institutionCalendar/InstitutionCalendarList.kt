package com.example.pocofdigivalapp.data.institutionCalendar

import com.google.gson.annotations.SerializedName

data class InstitutionCalendarList(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("calendar_name")
    val calendarName: String?,
)