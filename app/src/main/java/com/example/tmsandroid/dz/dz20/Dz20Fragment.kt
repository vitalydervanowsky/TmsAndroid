package com.example.tmsandroid.dz.dz20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tmsandroid.databinding.FragmentDz20Binding

class Dz20Fragment : Fragment() {
    private var _binding: FragmentDz20Binding? = null
    private val binding get() = _binding!!

    private val timer by lazy {
        ViewModelProvider(this).get(TimerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz20Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTvSeconds()
        binding.bStart.setOnClickListener {
            val mSeconds = if (binding.eStartSeconds.text.toString() != "")
                binding.eStartSeconds.text.toString().toLong() * 1000
            else
                0
            timer.startTimer(mSeconds)
            setTvSeconds()
        }
    }

    private fun setTvSeconds() {
        timer.liveData.observe(viewLifecycleOwner, {
            binding.tvSeconds.text = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}