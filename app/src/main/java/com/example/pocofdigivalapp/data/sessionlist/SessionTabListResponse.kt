package com.example.pocofdigivalapp.data.sessionlist

import com.example.pocofdigivalapp.data.sessionlist.SessionTabItem
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SessionTabListResponse(
    @SerializedName("status_code")
    @Expose
    var statusCode: Int? = null,

    @SerializedName("status")
    @Expose
    var status: Boolean? = null,

    @SerializedName("message")
    @Expose
    var message: String? = null,

    @SerializedName("data")
    @Expose
    val SessionTabItem: ArrayList<SessionTabItem?>?,
)