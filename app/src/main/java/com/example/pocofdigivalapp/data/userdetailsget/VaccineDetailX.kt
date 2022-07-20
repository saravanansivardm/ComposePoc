package com.example.pocofdigivalapp.data.userdetailsget


import com.google.gson.annotations.SerializedName

data class VaccineDetailX(
    @SerializedName("antigenName")
    val antigenName: String,
    @SerializedName("boosterDetails")
    val boosterDetails: List<BoosterDetail>,
    @SerializedName("brandName")
    val brandName: String,
    @SerializedName("companyName")
    val companyName: String,
    @SerializedName("dosageDetails")
    val dosageDetails: List<DosageDetail>,
    @SerializedName("_id")
    val id: String,
    @SerializedName("noOfBooster")
    val noOfBooster: Int,
    @SerializedName("noOfDosage")
    val noOfDosage: Int,
    @SerializedName("vaccineName")
    val vaccineName: String,
    @SerializedName("vaccineNumber")
    val vaccineNumber: String,
    @SerializedName("vaccineType")
    val vaccineType: String
)