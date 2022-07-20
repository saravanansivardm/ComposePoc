package com.example.pocofdigivalapp.data.course


import com.example.pocofdigivalapp.data.staff.ScheduleStaffItem
import com.example.pocofdigivalapp.data.staff.SubjectModel
import com.google.gson.annotations.SerializedName

data class CourseStaffFeedback(
    @SerializedName("_course_id")
    val _course_id: String?,
    @SerializedName("level_no")
    val level_no: String?,
    @SerializedName("year_no")
    val year_no: String?,
    @SerializedName("totalFeedback")
    val totalFeedback: Int?,
    @SerializedName("sessionCompletedCount")
    val sessionCompletedCount: Int?,
    @SerializedName("sessionCount")
    val sessionCount: Int?,
    @SerializedName("avgRating")
    val avgRating: String?,
    @SerializedName("rotation")
    val rotation: String?,
    @SerializedName("rotationCount")
    val rotationCount: String?,
    @SerializedName("staffs")
    val staffsDetails: ScheduleStaffItem?,
    @SerializedName("subjects")
    var subjects: ArrayList<SubjectModel?>? = null
)
