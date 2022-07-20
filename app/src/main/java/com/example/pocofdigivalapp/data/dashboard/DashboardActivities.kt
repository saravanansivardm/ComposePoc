package com.example.pocofdigivalapp.data.dashboard

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DashboardActivities(
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("_id")
    val id: String? = null,
    @SerializedName("_sessionId")
    val sessionId: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("quizType")
    val quizType: String? = null,
    @SerializedName("createdBy")
    val createdBy: String? = null,
    @SerializedName("startTime")
    @Expose
    val startTime: String? = null,
    @SerializedName("endTime")
    @Expose
    val endTime: String? = null,
    @SerializedName("setQuizTime")
    @Expose
    val setQuizTime: Long? = null,
    @SerializedName("answeredCount")
    @Expose
    val answeredCount: Int? = null,
//    @SerializedName("questions")
//    val question: ArrayList<ActivityQuestion?>? = null,
    @SerializedName("staffStartWithExam")
    @Expose
    val staffStartWithExam: String? = null,
    @SerializedName("totalQuestionCount")
    @Expose
    var totalQuestionCount: Int?,
    @SerializedName("totalStudentAnsweredCount")
    @Expose
    var totalStudentAnsweredCount: Int?,
    @SerializedName("totalStudentCount")
    @Expose
    var totalStudentCount: Int?,
    @SerializedName("studentCorrectAnsweredCount")
    @Expose
    var studentCorrectAnsweredCount: Int?,

    )