package com.example.pocofdigivalapp.data.institutionCalendar

import com.example.pocofdigivalapp.data.institutionCalendar.InstitutionCalendarList
import com.google.gson.annotations.SerializedName

data class InstitutionCalendarResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val dataList: ArrayList<InstitutionCalendarList>,
)