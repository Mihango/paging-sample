package com.techmashinani.pagingsample.models

import com.google.gson.annotations.SerializedName

data class Owner(
    var reputation: Int?,

    @SerializedName("user_id")
    var userId: Int?,

    @SerializedName("user_type")
    var userType: String?,

    @SerializedName("profile_image")
    var profileImage: String?,

    @SerializedName("display_name")
    var displayName: String?,

    var link: String?
)