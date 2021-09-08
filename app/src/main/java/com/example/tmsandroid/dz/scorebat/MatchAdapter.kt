package com.example.tmsandroid.dz.scorebat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.ItemMatchBinding

class MatchAdapter(
    private val data: List<Match>,
    private val delegate: (Match) -> Unit
) : RecyclerView.Adapter<MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val binding = ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(data[position], delegate)
    }

    override fun getItemCount(): Int = data.size
}

class MatchViewHolder(val binding: ItemMatchBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(match: Match, delegate: (Match) -> Unit) {
        binding.apply {
            tvMatchDate.text = match.date
            Glide.with(itemView)
                .load(match.thumbnail)
                .placeholder(R.drawable.img_placeholder_300_300)
                .into(ivMatchLogo)
            tvMatchTitle.text = match.title
            tvMatchLeague.text = match.competition
        }
        itemView.setOnClickListener {
            delegate(match)

        }

    }
}
