package com.example.tmsandroid.dz.dz16

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz16Task2Binding

class Dz16Task2Fragment : Fragment() {
    private var _binding: FragmentDz16Task2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz16Task2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bTask2Run.setOnClickListener {
            val a = binding.eTask2A.text.toString().toInt()
            val b = binding.eTask2B.text.toString().toInt()
            val c = binding.eTask2C.text.toString().toInt()
            val max: (Int, Int, Int) -> Int = { a, b, c ->
                val left = a * b * c
                val right = a + b + c
                val result = if (left > right)
                    left
                else
                    right
                result
            }

            binding.tvTask2Result.text = max(a, b, c).toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}