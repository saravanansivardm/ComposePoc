package com.example.pocofdigivalapp.data.sessionlist

import com.example.pocofdigivalapp.data.course.CourseItem
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SessionListResponse(
    @SerializedName("status_code")
    @Expose
    var statusCode: Int? = null,

    @SerializedName("status")
    @Expose
    var status: Boolean? = null,

    @SerializedName("message")
    @Expose
    var message: String? = null,

    // It will have only one item
    @SerializedName("data")
    @Expose
    val courseList: ArrayList<CourseItem?>?,

    //
    var tabData: ArrayList<Pair<Int, String?>> = arrayListOf(),
)