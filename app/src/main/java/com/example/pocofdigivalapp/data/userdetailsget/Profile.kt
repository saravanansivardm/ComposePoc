package com.example.pocofdigivalapp.data.userdetailsget


import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("basicDetails")
    val basicDetails: Boolean,
    @SerializedName("vaccinationDetails")
    val vaccinationDetails: Boolean
)