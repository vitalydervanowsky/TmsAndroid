package com.example.tmsandroid.dz.dz15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz15Task1Binding

class Dz15Task1Fragment : Fragment() {
    private var _binding: FragmentDz15Task1Binding? = null
    private val binding get() = _binding!!

    private var number = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz15Task1Binding.inflate(inflater, container, false)
        return binding.root
    }

    // Создать программу, которая будет проверять попало ли случайно выбранное из отрезка [5;155]
    // целое число в интервал (25;100) и сообщать результат на экран.

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNumber()

        binding.btnRandomTask1.setOnClickListener {
            setNumber()
        }

        binding.btnCheckTask1.setOnClickListener {
            binding.tvResultTask1.text = (number in 25..100).toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setNumber() {
        number = (5..155).random()
        binding.tvRandomTask1.text = number.toString()
    }
}