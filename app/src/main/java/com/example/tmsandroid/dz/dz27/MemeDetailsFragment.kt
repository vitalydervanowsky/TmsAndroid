package com.example.tmsandroid.dz.dz27

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentMemeDetailsBinding

class MemeDetailsFragment : Fragment() {

    private var _binding: FragmentMemeDetailsBinding? = null
    private val binding get() = _binding!!

    private val memeViewModel: MemeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMemeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        memeViewModel.currentMemeLiveData.observe(viewLifecycleOwner, {
            binding.apply {
                val date = it.created
                val textDate = date.substringBefore('T') + " at " + date.substringAfter('T')
                tvMemeDate.text = textDate
                tvMemeTitle.text = it.submission_title
                when {
                    isImage(it.submission_url) ->
                        Glide.with(ivMemeImage)
                            .load(it.submission_url)
                            .placeholder(R.drawable.img_placeholder_300_300)
                            .error(R.drawable.img_placeholder_300_300)
                            .into(ivMemeImage)
                    isYoutube(it.submission_url) ->
                        Glide.with(ivMemeImage)
                            .load(R.drawable.img_youtube_placeholder)
                            .placeholder(R.drawable.img_placeholder_300_300)
                            .error(R.drawable.img_placeholder_300_300)
                            .into(ivMemeImage)
                }
                val author = "author: " + it.author
                tvMemeAuthor.text = author
            }
        })
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