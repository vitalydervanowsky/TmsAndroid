package com.example.tmsandroid.dz.dz14

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.databinding.FragmentDz14Task2Binding

class Dz14Task2Fragment : Fragment() {
    private var _binding: FragmentDz14Task2Binding? = null
    private val binding get() = _binding!!

    private val puzzles = arrayListOf(
        "Заплелись густые травы,\n" +
                "Закудрявились луга,\n" +
                "Да и сам я весь кудрявый,\n" +
                "Даже завитком рога.",
        "Он кудрявый очень, очень,\n" +
                "Стать шашлыком совсем не хочет,\n" +
                "Среди ярок - великан,\n" +
                "Как зовут его?",
        "У него огромный рот,\n" +
                "Он зовется …",
        "Хожу в пушистой шубе,\n" +
                "Живу в густом лесу.\n" +
                "В дупле на старом дубе\n" +
                "Орешки я грызу.",
        "С ветки на ветку,\n" +
                "Быстрый, как мяч,\n" +
                "Скачет по лесу\n" +
                "Рыжий циркач.\n" +
                "Вот на лету он\n" +
                "Шишку сорвал,\n" +
                "Прыгнул на ствол\n" +
                "И в дупло убежал.\n"
    )

    private val keys = arrayListOf(
        "баран",
        "баран",
        "бегемот",
        "белка",
        "белка"
    )

    private val size = puzzles.size - 1
    private var number = (0..size).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz14Task2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showPuzzle(number)

        binding.apply {
            buttonShowAnswer.setOnClickListener {
                showAnswer()
            }
            buttonNextPuzzle.setOnClickListener {
                nextPuzzle()
            }
            buttonCheckAnswer.setOnClickListener {
                checkAnswer()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showPuzzle(number: Int) {
        binding.tvPuzzle.text = puzzles[number]
        binding.editPuzzleAnswer.setText("")
        binding.tvPuzzleAnswer.text = ""
    }

    private fun checkAnswer() {
        val answer = binding.editPuzzleAnswer.text.toString().lowercase()
        binding.tvPuzzleAnswer.text = (answer == keys[number]).toString()
    }

    private fun showAnswer() {
        binding.tvPuzzleAnswer.text = keys[number]
    }

    private fun nextPuzzle() {
        number++
        if (number > size) {
            number = 0
        }
        showPuzzle(number)
    }
}