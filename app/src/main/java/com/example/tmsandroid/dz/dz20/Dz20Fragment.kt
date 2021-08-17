package com.example.tmsandroid.dz.dz20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz20Binding

class Dz20Fragment : Fragment() {
    private var _binding: FragmentDz20Binding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[TimerViewModel::class.java]
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
        binding.apply {
            bStart.setOnClickListener {
                bStart.isEnabled = false
                eStartSeconds.isEnabled = false
                val mSeconds = if (eStartSeconds.text.toString() != "")
                    eStartSeconds.text.toString().toLong() * 1000
                else
                    0
                viewModel.startTimer(mSeconds)
                setTvSeconds()
            }
        }
        listenCount()
    }

    private fun listenCount() {
        viewModel.isFinishLiveData.observe(viewLifecycleOwner, {
            if (it) {
                binding.bStart.isEnabled = true
                binding.eStartSeconds.isEnabled = true
                binding.tvSeconds.text = getString(R.string.done)
            }
        })
        viewModel.isStartedLiveData.observe(viewLifecycleOwner, {
            if (it) {
                binding.bStart.isEnabled = false
                binding.eStartSeconds.isEnabled = false
            }
        })
    }

    private fun setTvSeconds() {
        viewModel.secondsLiveData.observe(viewLifecycleOwner, {
            val text = getString(R.string.seconds_remaining) + it
            binding.tvSeconds.text = text
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}