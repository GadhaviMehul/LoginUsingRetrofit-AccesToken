package com.example.mehulevent22024.models.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("user_device_id")
    val userDeviceId: String,
    @SerializedName("fcm_token")
    val fcmToken: String

) : Parcelable
