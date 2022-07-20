package com.example.pocofdigivalapp.data.userdetailsget


import com.google.gson.annotations.SerializedName

data class LabelDetail(
    @SerializedName("addressDetails")
    val addressDetails: List<AddressDetail>,
    @SerializedName("basicDetails")
    val basicDetails: List<BasicDetail>,
    @SerializedName("contactDetails")
    val contactDetails: List<ContactDetail>,
    @SerializedName("_id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("profileDetails")
    val profileDetails: List<ProfileDetail>
)