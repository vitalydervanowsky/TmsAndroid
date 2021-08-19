package com.example.tmsandroid.dz.dz23

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmsandroid.R

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.tv_name)
    private val country: TextView = itemView.findViewById(R.id.tv_country)
    private val logo: ImageView = itemView.findViewById(R.id.iv_logo)

    fun bind(car: Car) {
        name.text = car.name
        country.text = car.country
        Glide.with(itemView)
            .load(car.logo)
            .placeholder(R.drawable.img_placeholder_300_300)
            .error(R.drawable.img_placeholder_300_300)
            .into(logo)
    }
}