package com.example.pocofdigivalapp.data.dashboard

import com.google.gson.annotations.SerializedName

data class DashboardResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val dashboardData: DashboardData?,
)