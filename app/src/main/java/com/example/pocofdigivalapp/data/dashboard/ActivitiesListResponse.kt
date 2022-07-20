package com.example.pocofdigivalapp.data.dashboard

import com.google.gson.annotations.SerializedName

data class ActivitiesListResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("totalDoc")
    val totalDoc: Int?,
    @SerializedName("totalPages")
    val totalPages: Int?,
    @SerializedName("currentPage")
    val currentPage: Int?,
    @SerializedName("data")
    val activityList: ArrayList<ActivityListItem?>?,
)