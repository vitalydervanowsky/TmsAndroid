package com.example.tmsandroid.dz.scorebat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentMatchDetailsBinding

class MatchDetailsFragment : Fragment() {

    private var _binding: FragmentMatchDetailsBinding? = null
    private val binding get() = _binding!!

    private val matchViewModel: MatchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        matchViewModel.currentMatchLiveData.observe(viewLifecycleOwner, {
            binding.apply {
                tvMatchDate.text = it.date
                Glide.with(ivMatchLogo)
                    .load(it.thumbnail)
                    .placeholder(R.drawable.img_placeholder_300_300)
                    .into(ivMatchLogo)
                tvMatchTitle.text = it.title
                tvMatchLeague.text = it.competition
            }
        })

    }
}