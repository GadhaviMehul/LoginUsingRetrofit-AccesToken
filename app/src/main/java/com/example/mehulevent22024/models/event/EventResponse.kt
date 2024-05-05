package com.example.mehulevent22024.models.event

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class EventResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("expired_message")
    val expiredMessage: String,
    @SerializedName("message")
    val message: String
) : Parcelable {
    @Parcelize
    data class Data(
        @SerializedName("event_end_date")
        val eventEndDate: String,
        @SerializedName("event_start_date")
        val eventStartDate: String,
        @SerializedName("event_title")
        val eventTitle: String,
        @SerializedName("expired_flag")
        val expiredFlag: String,
        @SerializedName("group_details")
        val groupDetails: GroupDetails,
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: String,
        @SerializedName("is_group")
        val isGroup: String,
        @SerializedName("offring")
        val offring: Boolean,
        @SerializedName("pitch")
        val pitch: Boolean,
        @SerializedName("seeking")
        val seeking: Boolean,
        @SerializedName("user_role")
        val userRole: UserRole
    ) : Parcelable {
        @Parcelize
        data class GroupDetails(
            @SerializedName("count")
            val count: @RawValue Any?=null,
            @SerializedName("details")
            val details: List<Detail>,
            @SerializedName("group_image")
            val groupImage: String,
            @SerializedName("group_name")
            val groupName: String,
            @SerializedName("id")
            val id: String
        ) : Parcelable {
            @Parcelize
            data class Detail(
                @SerializedName("image")
                val image: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("user_id")
                val userId: String
            ) : Parcelable
        }

        @Parcelize
        data class UserRole(
            @SerializedName("force_meeting")
            val forceMeeting: Int,
            @SerializedName("force_meeting_flag")
            val forceMeetingFlag: String,
            @SerializedName("max_meeting_non_privilage")
            val maxMeetingNonPrivilage: String,
            @SerializedName("max_meeting_privilage")
            val maxMeetingPrivilage: String,
            @SerializedName("max_workshop")
            val maxWorkshop: String,
            @SerializedName("role_id")
            val roleId: String
        ) : Parcelable
    }
}