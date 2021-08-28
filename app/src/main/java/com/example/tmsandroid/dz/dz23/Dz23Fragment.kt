package com.example.tmsandroid.dz.dz23

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz23Binding

class Dz23Fragment : Fragment() {
    private var _binding: FragmentDz23Binding? = null
    private val binding get() = _binding!!
    private lateinit var carViewModel: CarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this.context as AppCompatActivity
        carViewModel = activity.run { ViewModelProviders.of(context)[CarViewModel::class.java] }
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

        carViewModel.setup()
        carViewModel.carsLiveData.observe(viewLifecycleOwner, {
            binding.rvList.adapter = CarAdapter(it) {
                carViewModel.setCar(it)
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, CarDetailsFragment())
                    .commit()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}