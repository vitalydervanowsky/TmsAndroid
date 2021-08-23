package com.example.tmsandroid.dz.dz23

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmsandroid.databinding.ItemCarBinding

class CarAdapter(private val data: List<Car>) : RecyclerView.Adapter<CarViewHolder>() {
    var callback: CarViewInterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(data[position], callback)
    }

    override fun getItemCount(): Int = data.size

    fun carViewCallback(callback: CarViewInterface) {
        this.callback = callback
    }
}