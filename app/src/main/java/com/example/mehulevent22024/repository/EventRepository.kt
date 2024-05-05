package com.example.mehulevent22024.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mehulevent22024.api.ApiService
import com.example.mehulevent22024.models.event.EventRequest
import com.example.mehulevent22024.models.event.EventResponse

class EventRepository(private val apiService: ApiService, private val eventRequest: EventRequest) {

    private var eventLiveData = MutableLiveData<MutableList<EventResponse>>()

    val event: LiveData<MutableList<EventResponse>>
        get() = eventLiveData

    suspend fun getEventData() {
        val temp = apiService.getEventData(eventRequest)
        if (temp.body() != null) {
            eventLiveData.postValue(mutableListOf(temp.body()!!))
        }
    }
}