package com.example.tmsandroid.dz.dz26

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentNewWordBinding

class NewWordFragment : Fragment() {

    private var _binding: FragmentNewWordBinding? = null
    private val binding get() = _binding!!
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((activity?.application as WordsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewWordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSave.setOnClickListener {
            if (TextUtils.isEmpty(binding.editWord.text)) {
                Toast.makeText(requireContext(), getString(R.string.please_fill_out_field), Toast.LENGTH_SHORT).show()
            } else {
                val word = binding.editWord.text.toString()
                val toastText = getString(R.string.new_word_is_added) + "\n" + word
                Toast.makeText(requireContext(), toastText, Toast.LENGTH_SHORT).show()
                wordViewModel.insert(Word(word))
                activity?.onBackPressed()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}