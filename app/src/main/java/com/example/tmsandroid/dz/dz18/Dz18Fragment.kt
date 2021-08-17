package com.example.tmsandroid.dz.dz18

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tmsandroid.databinding.FragmentDz18Binding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Dz18Fragment : Fragment() {
    private var _binding: FragmentDz18Binding? = null
    private val binding get() = _binding!!

    private val arr = Array(6) { Array(3) { 0 } }
    private lateinit var regions: Array<String>
    private lateinit var regionsView: Array<Array<TextView>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz18Binding.inflate(inflater, container, false)
        return binding.root
    }

    @DelicateCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            regions = arrayOf(
                tvBrest.text.toString(),
                tvVitebsk.text.toString(),
                tvGomel.text.toString(),
                tvGrodno.text.toString(),
                tvMogilev.text.toString(),
                tvMinsk.text.toString()
            )
            regionsView = arrayOf(
                arrayOf(tvBrestPotato, tvBrestCabbage, tvBrestBeet),
                arrayOf(tvVitebskPotato, tvVitebskCabbage, tvVitebskBeet),
                arrayOf(tvGomelPotato, tvGomelCabbage, tvGomelBeet),
                arrayOf(tvGrodnoPotato, tvGrodnoCabbage, tvGrodnoBeet),
                arrayOf(tvMogilevPotato, tvMogilevCabbage, tvMogilevBeet),
                arrayOf(tvMinskPotato, tvMinskCabbage, tvMinskBeet)
            )

            for (i in arr.indices) {
                for (j in arr[i].indices) {
                    setText(i, j)
                }
            }

            bStart.setOnClickListener {
                it.isEnabled = false
                startOfHarvest()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @DelicateCoroutinesApi
    private fun startOfHarvest() {
        GlobalScope.launch {
            while (true) {
                val i = rand(5) // region [0..5]
                val j = rand(2) // vegetable [0..2]
                arr[i][j] += rand(20)

                activity?.runOnUiThread {
                    setText(i, j)
                }
                delay(300)

                val result = arr[i][0] >= 100 && arr[i][1] >= 100 && arr[i][2] >= 100
                activity?.runOnUiThread {
                    if (result) {
                        binding.tvResult.text = regions[i]
                        binding.bStart.isEnabled = true
                    }
                }
                if (result)
                    break
            }
        }
    }

    private fun setText(i: Int, j: Int) {
        regionsView[i][j].text = arr[i][j].toString()
    }

    private fun rand(i: Int): Int {
        return (0..i).random()
    }
}