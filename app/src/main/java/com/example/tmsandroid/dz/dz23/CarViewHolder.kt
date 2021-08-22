package com.example.tmsandroid.dz.dz23

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.ItemCarBinding

class CarViewHolder(val binding: ItemCarBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(car: Car) {
        binding.apply {
            tvName.text = car.name
            tvCountry.text = car.country
            Glide.with(itemView)
                .load(car.logo)
                .placeholder(R.drawable.img_placeholder_300_300)
                .error(R.drawable.img_placeholder_300_300)
                .into(ivLogo)
        }
    }
}