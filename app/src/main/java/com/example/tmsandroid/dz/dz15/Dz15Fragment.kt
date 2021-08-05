package com.example.tmsandroid.dz.dz15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz15Binding
import com.example.tmsandroid.dz.dz14.Dz14Task1Fragment
import com.example.tmsandroid.dz.dz14.Dz14Task2Fragment
import com.example.tmsandroid.dz.dz14.Dz14Task3Fragment

class Dz15Fragment : Fragment() {
    private var _binding: FragmentDz15Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz15Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnTask1.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, Dz15Task1Fragment())
                    .commit()
            }

//            btnTask2.setOnClickListener {
//                parentFragmentManager.beginTransaction()
//                    .addToBackStack(null)
//                    .replace(R.id.container, Dz15Task2Fragment())
//                    .commit()
//            }
//
//            btnTask3.setOnClickListener {
//                parentFragmentManager.beginTransaction()
//                    .addToBackStack(null)
//                    .replace(R.id.container, Dz15Task3Fragment())
//                    .commit()
//            }
//
//            btnTask4.setOnClickListener {
//                parentFragmentManager.beginTransaction()
//                    .addToBackStack(null)
//                    .replace(R.id.container, Dz15Task4Fragment())
//                    .commit()
//            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}