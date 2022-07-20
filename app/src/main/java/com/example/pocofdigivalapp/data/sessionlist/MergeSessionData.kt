package com.example.pocofdigivalapp.data.sessionlist

import com.google.gson.annotations.SerializedName

class MergeSessionData {

    @SerializedName("_id")
    var id: String? = ""

    @SerializedName("schedule_id")
    var scheduleId: String? = ""

    @SerializedName("session_id")
    var sessionId: String? = ""

    @SerializedName("session")
    var session: MergeSessionDetails? = null

}