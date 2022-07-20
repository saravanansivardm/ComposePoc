package com.example.pocofdigivalapp.data.userdetailsget


import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("_institution_id")
    val institutionId: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isDeleted")
    val isDeleted: Boolean,
    @SerializedName("name")
    val name: Name,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("user_type")
    val userType: String,
    @SerializedName("verification")
    val verification: Verification
)