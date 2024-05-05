package com.example.mehulevent22024.models.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class LoginResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String
) : Parcelable {
    @Parcelize
    data class Data(
        @SerializedName("access_token")
        val accessToken: String,
        @SerializedName("company_name")
        val companyName: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("event_joined")
        val eventJoined: Boolean,
        @SerializedName("fcm_token")
        val fcmToken: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("stripe_customer_id")
        val stripeCustomerId: String,
        @SerializedName("user_device_id")
        val userDeviceId: String,
        @SerializedName("user_id")
        val userId: Int
    ) : Parcelable
}