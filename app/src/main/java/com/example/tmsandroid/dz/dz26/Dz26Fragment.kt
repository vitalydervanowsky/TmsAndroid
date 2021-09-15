package com.example.tmsandroid.dz.dz26

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz26Binding

class Dz26Fragment : Fragment() {

    private var _binding: FragmentDz26Binding? = null
    private val binding get() = _binding!!
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((activity?.application as WordsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz26Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = WordListAdapter {
            wordViewModel.deleteWord(it)
        }
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext()) // this

        wordViewModel.allWords.observe(viewLifecycleOwner, { words ->
            adapter.submitList(words)
        })

        binding.fab.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, NewWordFragment())
                .commit()
        }

        binding.bDeleteAll.setOnClickListener {
            val title = getString(R.string.delete_db_title)
            val message = getString(R.string.delete_db_message)
            val yes = getString(R.string.yes)
            val no = getString(R.string.no)
            val builder = AlertDialog.Builder(binding.root.context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(yes) { _, _ ->
                    wordViewModel.deleteAll()
                    val toastText = getString(R.string.db_is_deleted_successfully)
                    Toast.makeText(this.context, toastText, Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(no) { _, _ -> }
                .create()
            builder.show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}