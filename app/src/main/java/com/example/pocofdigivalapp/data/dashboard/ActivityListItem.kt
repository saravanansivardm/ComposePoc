package com.example.pocofdigivalapp.data.dashboard

import com.example.pocofdigivalapp.data.course.CourseItem
import com.example.pocofdigivalapp.data.sessionlist.SessionForUser
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ActivityListItem(
    @SerializedName("status")
    var status: String?,
    @SerializedName("_id")
    var id: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("quizType")
    var quizType: String?,
//    @SerializedName("questions")
//    var question: ArrayList<ActivityQuestion?>?,
//    @SerializedName("createdBy")
//    var createdBy: ActivitiesCreatedBy?,
    @SerializedName("socketEventStaffId")
    @Expose
    var socketEventStaffId: String?,
    @SerializedName("socketEventStudentId")
    @Expose
    var socketEventStudentId: String?,
    @SerializedName("staffStartWithExam")
    @Expose
    var staffStartWithExam: String?,
    @SerializedName("setQuizTime")
    @Expose
    var setQuizTime: Long?,
    @SerializedName("answeredCount")
    @Expose
    var answeredCount: Int?,
    @SerializedName("totalQuestionCount")
    @Expose
    var totalQuestionCount: Int?,
    @SerializedName("totalStudentAnsweredCount")
    @Expose
    var totalStudentAnsweredCount: Int?,
    @SerializedName("totalStudentCount")
    @Expose
    var totalStudentCount: Int?,
    @SerializedName("startTime")
    @Expose
    var startTime: String?,
    @SerializedName("endTime")
    @Expose
    var endTime: String?,
    @SerializedName("studentCorrectAnsweredCount")
    @Expose
    var studentCorrectAnsweredCount: Int?,
    @SerializedName("courseId")
    var courseId: CourseItem?,
//    @SerializedName("schedule")
//    var schedule: ScheduleRequestData?,
    @SerializedName("courseAdmin")
    var courseAdmin: Boolean?,
    @SerializedName("studentGroupName")
    var studentGroupName: String?,
    @SerializedName("sessionFlowIds")
    val sessionsInActivity: ArrayList<SessionForUser?>? = null,
    @SerializedName("documentId")
    var documentId: String?,
    @SerializedName("documentName")
    var documentName: String?,
    @SerializedName("documentDate")
    var documentDate: String?,
    @SerializedName("documentType")
    var documentType: String?,
    @SerializedName("uploadBy")
    var uploadBy: String?,
    @SerializedName("documentUrl")
    var documentUrl: String?,
    @SerializedName("documentSessionsName")
    var documentSessionsName: String?,
    @SerializedName("selected")
    var isSelected: Boolean?
)