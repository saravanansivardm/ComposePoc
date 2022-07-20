package com.example.pocofdigivalapp.data.sessionlist

import com.google.gson.annotations.SerializedName

class MergeSessionDetails {
    @SerializedName("_session_id")
    var sessionId: String? = ""

    @SerializedName("delivery_symbol")
    var deliverySymbol: String? = ""

    @SerializedName("delivery_no")
    var deliveryNo: Int? = null

    @SerializedName("topic")
    var topic: String? = ""

    //Added on 27-01-2022
    @SerializedName("session_type")
    var sessionType: String? = ""

    @SerializedName("session_topic")
    var sessionTopic: String? = ""
}