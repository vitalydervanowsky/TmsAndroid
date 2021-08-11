package com.example.tmsandroid.dz.dz15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz15Task2Binding

class Dz15Task2Fragment : Fragment() {
    private var _binding: FragmentDz15Task2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz15Task2Binding.inflate(inflater, container, false)
        return binding.root
    }

    // Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех его цифр
    // (заранее не известно сколько цифр будет в числе).

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSumTask2.setOnClickListener {
            val list: List<Char> = binding.editNumberTask2.text.toString().toList()
            val sum = list.sumOf { it.code - 48 }
            binding.tvResultTask2.text = sum.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}