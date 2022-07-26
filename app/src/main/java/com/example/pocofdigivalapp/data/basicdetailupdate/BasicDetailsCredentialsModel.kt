package com.example.pocofdigivalapp.data.basicdetailupdate

import com.example.pocofdigivalapp.data.course.CourseItem
import com.google.gson.annotations.SerializedName

data class BasicDetailsCredentialsModel(
    @SerializedName("user_type")
    val user_type: String?,
    @SerializedName("setMode")
    val setMode: String?,
    @SerializedName("data")
    val data: BasicDetailsData,
)
