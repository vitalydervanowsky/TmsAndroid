package com.example.tmsandroid.dz.scorebat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tmsandroid.*
import com.example.tmsandroid.databinding.FragmentMatchListBinding

class MatchListFragment : Fragment() {

    private var _binding: FragmentMatchListBinding? = null
    private val binding get() = _binding!!

    private val matchViewModel: MatchViewModel by activityViewModels()
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(LAST_MATCH_KEY, Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        matchViewModel.matchesLiveData.observe(viewLifecycleOwner, {
            binding.rvMatchesList.adapter = MatchAdapter(it.response) { currentMatch ->
                matchViewModel.setCurrentMatch(currentMatch)
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, MatchDetailsFragment())
                    .commit()
            }
        })

        matchViewModel.lastMatchLiveData.observe(viewLifecycleOwner, {
            val date = it.date.substringBefore('T')
            sharedPrefs.edit()
                .putString(LAST_MATCH_THUMBNAIL_KEY, it.thumbnail)
                .putString(LAST_MATCH_TITLE_KEY, it.title)
                .putString(LAST_MATCH_COMPETITION_KEY, it.competition)
                .putString(LAST_MATCH_DATE_KEY, date)
                .apply()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}