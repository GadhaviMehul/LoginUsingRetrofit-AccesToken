package com.example.mehulevent22024.models.event

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventRequest(
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_device_id")
    val userDeviceId: String,
    @SerializedName("access_token")
    val accessToken: String
) : Parcelable