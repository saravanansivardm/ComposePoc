package com.example.pocofdigivalapp.data.userdetailsget


import com.google.gson.annotations.SerializedName

data class VaccineDetail(
    @SerializedName("allowMixedVaccine")
    val allowMixedVaccine: Boolean,
    @SerializedName("categoryName")
    val categoryName: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isMandatory")
    val isMandatory: Boolean,
    @SerializedName("vaccineDetails")
    val vaccineDetails: List<VaccineDetailX>
)