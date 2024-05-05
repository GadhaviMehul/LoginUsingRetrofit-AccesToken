package com.example.mehulevent22024.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mehulevent22024.databinding.SingleRowBinding
import com.example.mehulevent22024.models.event.EventResponse

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private var eventList = emptyList<EventResponse.Data>()

    inner class EventViewHolder(private val myItem: SingleRowBinding) :
        RecyclerView.ViewHolder(myItem.root) {
        fun bind(eventResponse: EventResponse.Data) {
            myItem.name.text = eventResponse.eventTitle
            Glide.with(myItem.imageview.context).load(eventResponse.image).into(myItem.imageview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = SingleRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val eventList = eventList[position]
        holder.bind(eventList)
    }

    override fun getItemCount(): Int = eventList.size

    fun setEventData(eventList: List<EventResponse.Data>) {
        this.eventList = eventList
    }

}