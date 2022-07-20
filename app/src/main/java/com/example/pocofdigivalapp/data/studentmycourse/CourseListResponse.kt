package com.example.pocofdigivalapp.data.studentmycourse

import com.google.gson.annotations.SerializedName

data class StudentCourseListResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val courseList: ArrayList<StudentCourseItem>,
)