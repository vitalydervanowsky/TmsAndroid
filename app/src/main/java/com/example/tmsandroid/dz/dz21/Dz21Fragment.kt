package com.example.tmsandroid.dz.dz21

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz21Binding

class Dz21Fragment : Fragment() {
    private var _binding: FragmentDz21Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz21Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = Intent(context, MyMediaPlayer::class.java)
        val stringUri = "android.resource://com.example.tmsandroid/raw/audio"
        intent.putExtra("stringUri", stringUri)

        binding.apply {
            bPlay.setOnClickListener {
                context?.startService(intent)
            }

            bStop.setOnClickListener {
                context?.stopService(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}