package com.example.tmsandroid.dz.dz15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz15Task3Binding

class Dz15Task3Fragment : Fragment() {
    private var _binding: FragmentDz15Task3Binding? = null
    private val binding get() = _binding!!

    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz15Task3Binding.inflate(inflater, container, false)
        return binding.root
    }

    // Посчитайте сумму всех чисел от 1 до 100

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var result = 0
        for (i in 1..100)
            result += i
        val text = "Сумма от 1 до 100 = \n$result"
        binding.tvResultTask3.text = text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}