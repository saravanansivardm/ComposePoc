package com.example.pocofdigivalapp.data.course

import com.example.pocofdigivalapp.data.sessionlist.SessionForUser
import com.example.pocofdigivalapp.data.sessionlist.SessionItem
import com.google.gson.annotations.SerializedName

data class CourseItem(
    @SerializedName("_id")
    val courseId: String?,
    @SerializedName("_program_id")
    val programId: String?,
    @SerializedName("course_name")
    val courseName: String? = "",
    @SerializedName("course_code")
    var courseCode: String? = "",
    @SerializedName("course_number")
    val courseNumber: String? = "",
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("totalSessions")
    val totalSessions: Int? = 0,
    @SerializedName("attendedSessions")
    val attendedSessions: Int? = 0,
    @SerializedName("completedSessions")
    val completedSessions: Int? = 0,
    @SerializedName("staffCompletedSessions")
    val staffCompletedSessions: Int? = 0,
    @SerializedName("year")
    var year: String? = "",
    @SerializedName("feedback")
    val feedback: CourseFeedback? = null,
    @SerializedName("staffFeedBacks")
    val staffFeedBacks: ArrayList<CourseStaffFeedback?>? = arrayListOf(),
    @SerializedName("session_type")
    val sessionType: String? = "",
    @SerializedName("session_topic")
    val sessionTopic: String? = "",
    @SerializedName("program_name")
    val programName: String? = "",
    @SerializedName("_institution_calendar_id")
    var institutionCalendarId: String? = null,
    @SerializedName("level")
    var level: String? = "",
    @SerializedName("courseStatus")
    var courseStatus: Int? = 0,
    @SerializedName("end_date")
    var endDate: String? = "",
    @SerializedName("start_date")
    var startDate: String? = "",
    @SerializedName("rotation")
    var rotation: String?,
    @SerializedName("rotation_count")
    var rotationCount: Int?,
    @SerializedName("year_no")
    var yearNo: String?,
    @SerializedName("level_no")
    var levelNo: String?,
    @SerializedName("term")
    var term: String?,
    @SerializedName("merged_status")
    var mergedStatus: Boolean? = false,
    //Only used in session list screen
    @SerializedName("sessions")
    val sessions: ArrayList<SessionItem?>? = arrayListOf(),
    @SerializedName("courseSessionDetails")
    val courseSessionDetails: ArrayList<CourseSessionDetails?>? = arrayListOf(),

    //local variable
    var selectedSessionsInAddDoc: ArrayList<SessionForUser?>? = arrayListOf(),
)