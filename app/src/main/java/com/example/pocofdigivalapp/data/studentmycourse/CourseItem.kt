package com.example.pocofdigivalapp.data.studentmycourse

import com.example.pocofdigivalapp.data.sessionlist.SessionItem
import com.google.gson.annotations.SerializedName

data class StudentCourseItem(
    @SerializedName("_id")
    val courseId: String?,

    @SerializedName("_institution_calendar_id")
    val institutionCalendarId: String?,

    @SerializedName("_program_id")
    val programId: String?,

    @SerializedName("course_name")
    val courseName: String?,

    @SerializedName("course_code")
    var courseCode: String?,

    @SerializedName("course_number")
    val courseNumber: String?,

    @SerializedName("totalSessions")
    val totalSessions: Int?,

    @SerializedName("completedSessions")
    val completedSessions: Int?,

    @SerializedName("presentCount")
    val presentCount: Int?,

    @SerializedName("year")
    val year: String?,

    @SerializedName("year_no")
    val yearNo: String?,

    @SerializedName("level_no")
    val levelNo: String?,

    @SerializedName("warningCount")
    val warning: Int?,

    @SerializedName("warningData")
    val warningData: String?,

    @SerializedName("absentPercentage")
    val absentPercentage: Double?,

    @SerializedName("program_name")
    val programName: String?,

    @SerializedName("level")
    val level: String?,

    @SerializedName("absentCount")
    val studentAbsentCount: Int?,

    @SerializedName("attendedSessions")
    val attendedSessions: Int?,

    @SerializedName("leaveCount")
    val studentLeaveCount: Int?,

    @SerializedName("start_date")
    val startDate: String?,

    @SerializedName("end_date")
    val endDate: String?,

    @SerializedName("rotation")
    val rotation: String?,

    @SerializedName("term")
    val term: String?,

    @SerializedName("rotation_count")
    val rotationCount: Int?,

    //Only used in session list screen
    @SerializedName("sessions")
    val sessions: ArrayList<SessionItem?>,
)