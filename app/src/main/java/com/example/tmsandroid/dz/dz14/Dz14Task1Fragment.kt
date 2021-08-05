package com.example.tmsandroid.dz.dz14

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz14Task1Binding

class Dz14Task1Fragment : Fragment() {
    private var _binding: FragmentDz14Task1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz14Task1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val answers = listOf(
            "Да",
            "Нет",
            "Скорее всего да",
            "Скорее всего нет",
            "Возможно",
            "Имеются перспективы",
            "Вопрос задан неверно"
        )

        binding.buttonAnswer.setOnClickListener {
            binding.tvResultTask1.text = answers.random()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}