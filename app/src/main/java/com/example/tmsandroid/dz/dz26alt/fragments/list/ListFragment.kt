package com.example.tmsandroid.dz.dz26alt.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentListBinding
import com.example.tmsandroid.dz.dz26alt.viewmodel.WordViewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val wordViewModel: WordViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val deleteStrings = listOf<String>(
            getString(R.string.delete_item_title),
            getString(R.string.delete_item_message),
            getString(R.string.yes),
            getString(R.string.no),
        )
        val adapter = ListAdapter(deleteStrings) {
            wordViewModel.deleteWord(it)
        }
        wordViewModel.readAllData.observe(viewLifecycleOwner, {
            adapter.setData(it)
            binding.rvList.adapter = adapter
        })

        binding.rvList.layoutManager = LinearLayoutManager(requireContext())

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        binding.bClearDb.setOnClickListener {
            val title = getString(R.string.delete_db_title)
            val message = getString(R.string.delete_db_message)
            val yes = getString(R.string.yes)
            val no = getString(R.string.no)
            val builder = AlertDialog.Builder(binding.root.context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(yes) { _, _ ->
                    wordViewModel.clearDb()
                    val toastText = getString(R.string.db_is_deleted_successfully)
                    Toast.makeText(this.context, toastText, Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(no) { _, _ -> }
                .create()
            builder.show()
        }

    }

}