package com.example.tmsandroid.dz.dz27

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentMemeListBinding

class MemeListFragment : Fragment() {

    private var _binding: FragmentMemeListBinding? = null
    private val binding get() = _binding!!

    private val memesViewModel: MemeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMemeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        memesViewModel.memesLiveData.observe(viewLifecycleOwner, {
            binding.rvMemesList.adapter = MemeAdapter(it.data) { currentMeme ->
                memesViewModel.setCurrentMeme(currentMeme)
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, MemeDetailsFragment())
                    .commit()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}