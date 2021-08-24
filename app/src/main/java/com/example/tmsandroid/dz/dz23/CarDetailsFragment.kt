package com.example.tmsandroid.dz.dz23

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentCarDetailsBinding

class CarDetailsFragment(val car: Car) : Fragment() {
    private var _binding: FragmentCarDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            tvDetailsName.text = car.name
            tvDetailsCountry.text = car.country
            Glide.with(ivDetailsLogo)
                .load(car.logo)
                .placeholder(R.drawable.img_placeholder_300_300)
                .error(R.drawable.img_placeholder_300_300)
                .into(ivDetailsLogo)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}