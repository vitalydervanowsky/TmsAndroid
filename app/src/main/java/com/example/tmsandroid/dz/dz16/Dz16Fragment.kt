package com.example.tmsandroid.dz.dz16

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz15Binding
import com.example.tmsandroid.databinding.FragmentDz16Binding
import com.example.tmsandroid.dz.dz14.Dz14Task1Fragment
import com.example.tmsandroid.dz.dz14.Dz14Task2Fragment
import com.example.tmsandroid.dz.dz14.Dz14Task3Fragment
import com.example.tmsandroid.dz.dz15.Dz15Task1Fragment
import com.example.tmsandroid.dz.dz15.Dz15Task2Fragment
import com.example.tmsandroid.dz.dz15.Dz15Task3Fragment
import com.example.tmsandroid.dz.dz15.Dz15Task4Fragment

class Dz16Fragment : Fragment() {
    private var _binding: FragmentDz16Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz16Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            bTask1.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, Dz16Task1Fragment())
                    .commit()
            }

            bTask2.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, Dz16Task2Fragment())
                    .commit()
            }

            bTask3.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, Dz16Task3Fragment())
                    .commit()
            }

            bTask4.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, Dz16Task4Fragment())
                    .commit()
            }

            bTask5.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, Dz16Task5Fragment())
                    .commit()
            }

            bTask6.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, Dz16Task6Fragment())
                    .commit()
            }

            bTask7.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, Dz16Task7Fragment())
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}