package com.example.mehulevent22024.api

import com.example.mehulevent22024.models.event.EventRequest
import com.example.mehulevent22024.models.event.EventResponse
import com.example.mehulevent22024.models.login.LoginRequest
import com.example.mehulevent22024.models.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun getLoginData(@Body loginRequest: LoginRequest):Response<LoginResponse>

    @POST("event-list")
    suspend fun getEventData(@Body eventRequest: EventRequest):Response<EventResponse>
}