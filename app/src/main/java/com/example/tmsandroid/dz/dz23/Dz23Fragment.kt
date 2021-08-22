package com.example.tmsandroid.dz.dz23

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz23Binding

class Dz23Fragment : Fragment() {
    private var _binding: FragmentDz23Binding? = null
    private val binding get() = _binding!!

    private val carViewModel by lazy {
        ViewModelProvider(this)[CarViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz23Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvList = getView()?.findViewById<RecyclerView>(R.id.rv_list)
        carViewModel.setup()
        carViewModel.carsLiveData.observe(viewLifecycleOwner, {
            rvList?.adapter = CarAdapter(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}