package com.example.pocofdigivalapp.data.staff

import com.google.gson.annotations.SerializedName

data class SubjectModel(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("_subject_id")
    val subjectId: String?,
    @SerializedName("subject_name")
    val subjectName: String?,
)