package com.example.pocofdigivalapp.data.course

import com.google.gson.annotations.SerializedName

data class CourseFeedback(
    @SerializedName("_course_id")
    val _course_id: String?,
    @SerializedName("level_no")
    val level_no: String?,
    @SerializedName("year_no")
    val year_no: String?,
    @SerializedName("totalFeedback")
    val totalFeedback: Int?,
    @SerializedName("sessionCount")
    val sessionCount: Int?,
    @SerializedName("avgRating")
    val avgRating: String?,
)