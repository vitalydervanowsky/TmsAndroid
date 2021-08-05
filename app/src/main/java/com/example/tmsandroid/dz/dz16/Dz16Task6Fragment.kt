package com.example.tmsandroid.dz.dz16

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz16Task6Binding
import java.math.BigInteger

class Dz16Task6Fragment : Fragment() {
    private var _binding: FragmentDz16Task6Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz16Task6Binding.inflate(inflater, container, false)
        return binding.root
    }

    // 6.Написать функцию, которая возвращает факториал числа N (n! = 1*2*…*n-1*n;)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            bTask6Run.setOnClickListener {
                val n = eTask6Number.text.toString().toLong()

                val factorial: (Long) -> BigInteger = {
                    var result = BigInteger.ONE
                    for (i in 2..n)
                        result = result.multiply(BigInteger.valueOf(i))
                    result
                }
                val text = factorial(n).toString()
                tvTask6Result.text = text
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}