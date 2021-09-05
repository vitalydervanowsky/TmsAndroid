package com.example.tmsandroid.dz.dz27

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.ItemMemeBinding

class MemeViewHolder(val binding: ItemMemeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(meme: Meme, delegate: (Meme) -> Unit) {
        binding.apply {
            val date = meme.created
            val textDate = date.substringBefore('T') + " at " + date.substringAfter('T')
            tvMemeDate.text = textDate
            tvMemeTitle.text = meme.submission_title
            if (isImage(meme.submission_url))
                Glide.with(itemView)
                    .load(meme.submission_url)
                    .placeholder(R.drawable.img_placeholder_300_300)
                    .error(R.drawable.img_placeholder_300_300)
                    .into(ivMemeImage)
            if (isYoutube(meme.submission_url))
                Glide.with(itemView)
                    .load(R.drawable.img_youtube_placeholder)
                    .placeholder(R.drawable.img_placeholder_300_300)
                    .error(R.drawable.img_placeholder_300_300)
                    .into(ivMemeImage)
            itemView.setOnClickListener {
                delegate(meme)
            }
        }
    }

    private fun isImage(url: String): Boolean {
        val length = url.length
        return url.substring(length - 3, length) == "jpg" ||
                url.substring(length - 3, length) == "png" ||
                url.substring(length - 3, length) == "gif"

    }

    private fun isYoutube(url: String): Boolean {
        return url.contains("https://youtu.be/")
    }
}