package com.example.tmsandroid.dz.dz16

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz16Task7Binding

class Dz16Task7Fragment : Fragment() {
    private var _binding: FragmentDz16Task7Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz16Task7Binding.inflate(inflater, container, false)
        return binding.root
    }

// 7.Написать функцию, которая возвратит строковое представление числа N(dec) в двоичном формате.

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            bTask7Run.setOnClickListener {
                val number = eTask7Number.text.toString().toInt()
                val toBinary: (Int) -> Long = {
                    var n = number
                    val sb = StringBuilder()
                    while (n / 2 != 0) {
                        val add = n % 2
                        sb.append(add)
                        n /= 2
                    }
                    sb.append(1).reverse().toString().toLong()
                }
                tvTask7Result.text = toBinary(number).toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}