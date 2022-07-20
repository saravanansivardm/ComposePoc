package com.example.pocofdigivalapp.data.userdetailsget


import com.google.gson.annotations.SerializedName

data class Labels(
    @SerializedName("labelDetails")
    val labelDetails: List<LabelDetail>,
    @SerializedName("vaccineDetails")
    val vaccineDetails: List<VaccineDetail>
)