package com.example.pocofdigivalapp.data.course

import com.example.pocofdigivalapp.data.course.CourseItem
import com.google.gson.annotations.SerializedName

data class CourseListResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val courseList: ArrayList<CourseItem>,
)