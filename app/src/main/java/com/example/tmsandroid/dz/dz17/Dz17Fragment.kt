package com.example.tmsandroid.dz.dz17

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz17Binding

class Dz17Fragment : Fragment() {
    private var _binding: FragmentDz17Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz17Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bStart.setOnClickListener {
            startTimer()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun startTimer() {
        val mSeconds = if (binding.eStartSeconds.text.toString() != "")
            binding.eStartSeconds.text.toString().toLong() * 1000
        else
            0
        object : CountDownTimer(mSeconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val s = "seconds remaining: " + millisUntilFinished / 1000
                binding.tvSeconds.text = s
            }

            override fun onFinish() {
                val s = "done!"
                binding.tvSeconds.text = s
            }
        }.start()
    }
}