package com.example.tmsandroid.dz.dz24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz24Binding

class Dz24Fragment : Fragment() {
    private var _binding: FragmentDz24Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz24Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bStartAnimation.setOnClickListener {
            AnimationUtils.loadAnimation(context, R.anim.translate).also {
                binding.bStartAnimation.startAnimation(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}