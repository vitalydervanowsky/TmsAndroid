package com.example.tmsandroid.dz.dz16

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz16Task4Binding

class Dz16Task4Fragment : Fragment() {
    private var _binding: FragmentDz16Task4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz16Task4Binding.inflate(inflater, container, false)
        return binding.root
    }

// 4.Есть два конверта со сторонами (а,б) и (в,г) определить, можно ли один конверт вложить в другой

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            bTask4Run.setOnClickListener {
                val x1 = eTask4Letter1X.text.toString().toInt()
                val y1 = eTask4Letter1Y.text.toString().toInt()

                val x2 = eTask4Letter2X.text.toString().toInt()
                val y2 = eTask4Letter2Y.text.toString().toInt()

                val cond1 = (x1 > x2 && y1 > y2) || (x1 > y2 && y1 > x2)
                val cond2 = (x2 > x1 && y2 > y1) || (x2 > y1 && y2 > x1)
                val result = when {
                    cond1 -> getString(R.string.letter1_contain_letter2)
                    cond2 -> getString(R.string.letter2_contain_letter1)
                    else -> getString(R.string.impossible)
                }

                tvTask4Result.text = result
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}