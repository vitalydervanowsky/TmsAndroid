package com.example.tmsandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tmsandroid.databinding.FragmentMenuBinding
import com.example.tmsandroid.dz.dz14.Dz14Fragment
import com.example.tmsandroid.dz.dz15.Dz15Fragment
import com.example.tmsandroid.dz.dz16.Dz16Fragment

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bDz14.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, Dz14Fragment())
                .commit()
        }

        binding.bDz15.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, Dz15Fragment())
                .commit()
        }

        binding.bDz16.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, Dz16Fragment())
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}