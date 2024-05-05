package com.example.mehulevent22024.viewModel.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mehulevent22024.models.event.EventResponse
import com.example.mehulevent22024.repository.EventRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventViewModel(private val repository: EventRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getEventData()
        }
    }

    val event: LiveData<MutableList<EventResponse>>
        get() = repository.event
}