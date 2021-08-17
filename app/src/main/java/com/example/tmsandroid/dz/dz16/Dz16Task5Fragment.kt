package com.example.tmsandroid.dz.dz16

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz16Task5Binding

class Dz16Task5Fragment : Fragment() {
    private var _binding: FragmentDz16Task5Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz16Task5Binding.inflate(inflater, container, false)
        return binding.root
    }

    // 5.Найти сумму четных чисел и их количество в диапазоне от 1 до 99

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var sum = 0
        for (i in 2..99 step 2)
            sum += i

        val text = getString(R.string.sum_of_even_1_99) + "\n$sum"
        binding.tvTask5Result.text = text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}