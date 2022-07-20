package com.example.pocofdigivalapp.data.dashboard

import com.example.pocofdigivalapp.data.course.CourseItem
import com.google.gson.annotations.SerializedName

data class DocumentItem(
    @SerializedName("isDeleted")
    val isDeleted: Boolean? = null,
    @SerializedName("starred")
    var starred: Boolean? = null,
    @SerializedName("isActive")
    val isActive: Boolean? = null,
    @SerializedName("_id")
    val documentId: String? = null,
    @SerializedName("_user_id")
    val userId: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("updatedAt")
    val updatedAt: String? = null,
    @SerializedName("courseDetail")
    val courseDetail: CourseItem? = null,
//    @SerializedName("UploadedBy")
//    val UploadedBy: ActivitiesCreatedBy? = null,
    @SerializedName("__v")
    val version: Int? = null,
    @SerializedName("sessions")
    val sessions: ArrayList<ScheduleItem?>,
    @SerializedName("courseAdmin")
    var courseAdmin: Boolean?,
    @SerializedName("createdBy")
    var createdBy: String?,
    @SerializedName("updatedDate")
    var updatedDate: String?,
    @SerializedName("sessionsName")
    var sessionsName: String?,
    @SerializedName("selected")
    var isSelected: Boolean?
)
