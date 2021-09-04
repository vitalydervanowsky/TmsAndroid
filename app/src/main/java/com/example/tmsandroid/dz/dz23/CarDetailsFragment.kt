package com.example.tmsandroid.dz.dz23

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentCarDetailsBinding

class CarDetailsFragment : Fragment() {
    private var _binding: FragmentCarDetailsBinding? = null
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
        _binding = FragmentCarDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carViewModel.currentCarLiveData.observe(viewLifecycleOwner, {
            binding.apply {
                tvDetailsName.text = it.name
                tvDetailsCountry.text = it.country
                Glide.with(ivDetailsLogo)
                    .load(it.logo)
                    .placeholder(R.drawable.img_placeholder_300_300)
                    .error(R.drawable.img_placeholder_300_300)
                    .into(ivDetailsLogo)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}