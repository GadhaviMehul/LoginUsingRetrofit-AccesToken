package com.example.mehulevent22024.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mehulevent22024.R
import com.example.mehulevent22024.adapter.EventAdapter
import com.example.mehulevent22024.api.ApiService
import com.example.mehulevent22024.api.RetrofitHelper
import com.example.mehulevent22024.databinding.FragmentEventBinding
import com.example.mehulevent22024.models.event.EventRequest
import com.example.mehulevent22024.repository.EventRepository
import com.example.mehulevent22024.viewModel.event.EventViewModel
import com.example.mehulevent22024.viewModel.event.EventViewModelFactory

class EventFragment : Fragment() {
    private lateinit var binding: FragmentEventBinding
    private lateinit var viewModel: EventViewModel
    private lateinit var repository: EventRepository
    private val adapter = EventAdapter()
    private val args by navArgs<EventFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventBinding.inflate(inflater, container, false)
        setUpEventData()
        return binding.root

    }

    private fun setUpEventData() {

        val eventRequestModel = eventRequest()

        val apiService = RetrofitHelper.getUserData().create(ApiService::class.java)

        repository = EventRepository(apiService, eventRequestModel)

        viewModel =
            ViewModelProvider(this, EventViewModelFactory(repository))[EventViewModel::class.java]

        observerEventData()


    }

    private fun eventRequest(): EventRequest {
        val event = args.event.data
        return EventRequest(event.userId, event.userDeviceId, event.accessToken)
    }

    private fun observerEventData() {

        viewModel.event.observe(viewLifecycleOwner) { eventData ->
            eventData.firstOrNull()?.let {

                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerView.adapter = adapter
                adapter.setEventData(it.data)

            }

        }
    }

}