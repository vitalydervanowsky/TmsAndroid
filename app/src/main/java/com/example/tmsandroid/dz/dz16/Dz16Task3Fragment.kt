package com.example.tmsandroid.dz.dz16

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz16Task3Binding

class Dz16Task3Fragment : Fragment() {
    private var _binding: FragmentDz16Task3Binding? = null
    private val binding get() = _binding!!

    enum class Mark {
        A, B, C, D, E, F, NO_MARK
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz16Task3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            bTask3Run.setOnClickListener {
                val result = when (eTask3Number.text.toString().toInt()) {
                    in 0..19 -> Mark.F
                    in 20..39 -> Mark.E
                    in 40..59 -> Mark.D
                    in 60..74 -> Mark.C
                    in 75..89 -> Mark.B
                    in 90..100 -> Mark.A
                    else -> Mark.NO_MARK
                }

                tvTask3Result.text = result.toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}