package com.example.tmsandroid.dz.dz14

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz14Task3Binding

class Dz14Task3Fragment : Fragment() {
    private var _binding: FragmentDz14Task3Binding? = null
    private val binding get() = _binding!!

    private val abc = mapOf<Char, Int>(
        'а' to 1,
        'б' to 2,
        'в' to 3,
        'г' to 4,
        'д' to 5,
        'е' to 6,
        'ё' to 7,
        'ж' to 8,
        'з' to 9,
        'и' to 10,
        'й' to 11,
        'к' to 12,
        'л' to 13,
        'м' to 14,
        'н' to 15,
        'о' to 16,
        'п' to 17,
        'р' to 18,
        'с' to 19,
        'т' to 20,
        'у' to 21,
        'ф' to 22,
        'х' to 23,
        'ц' to 24,
        'ч' to 25,
        'ш' to 26,
        'щ' to 27,
        'ъ' to 28,
        'ы' to 29,
        'ь' to 30,
        'э' to 31,
        'ю' to 32,
        'я' to 33
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz14Task3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bCalculate.setOnClickListener {
            execute()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun execute() {
        val word = binding.eName1.text.toString() + binding.eName2.text.toString()
        val chars: List<Char> = word.lowercase().toList()
        var result = 0
        for (char in chars) {
            result += abc[char]!!
        }
        binding.tvResultTask3.text = result.toString()
    }
}