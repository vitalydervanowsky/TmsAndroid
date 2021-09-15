package com.example.tmsandroid.dz.dz26alt.fragments.add

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentAddBinding
import com.example.tmsandroid.dz.dz26alt.model.Word
import com.example.tmsandroid.dz.dz26alt.viewmodel.WordViewModel

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private val wordViewModel: WordViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        binding.buttonAdd.setOnClickListener {
            insertDataForDatabase()
        }

        return binding.root
    }

    private fun insertDataForDatabase() {
        val editWord = binding.editWord.text

        if (inputCheck(editWord)) {
            val word = Word(editWord.toString())
            wordViewModel.addWord(word)
            val toastText = getString(R.string.new_word_is_added) + "\n" + word.word
            Toast.makeText(
                requireContext(),
                toastText,
                Toast.LENGTH_SHORT
            ).show()
            activity?.onBackPressed()
        } else {
            val toastText = getString(R.string.please_fill_out_field)
            Toast.makeText(requireContext(), toastText, Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(word: Editable): Boolean {
        return word.isNotEmpty()
    }
}