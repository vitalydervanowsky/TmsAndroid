package com.example.tmsandroid.dz.dz15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz15Task4Binding

class Dz15Task4Fragment : Fragment() {
    private var _binding: FragmentDz15Task4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz15Task4Binding.inflate(inflater, container, false)
        return binding.root
    }

// Создать класс Cat. Кот имеет свойства имя, вес, цвет, рост, длина и зависящее от веса,
// роста и длины свойство - сила.
// Необходимо создать функцию, определяющую высоту прыжка кота, зависящую от базовых параметров
// кота (вес, рост, высота). Создать базовый класс Furniture (мебель), обладающий параметрами:
// высота, цвет, материал, длина. На базе класса Furniture создать класс Table (добавить параметр
// количество ножек). Реализовать взаимодействие двух объектов: Cat и Table. Вывести получилось ли
// у кота запрыгнуть на него.

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnCheckTask4.setOnClickListener {
                val catName: String = eCatName.text.toString()
                val catWeight = eCatWeight.text.toString().toDouble()
                val catColor = eCatColor.text.toString().toInt()
                val catHeight = eCatHeight.text.toString().toDouble()
                val catLength = eCatLength.text.toString().toDouble()

                val tableHeight = eTableHeight.text.toString().toDouble()
                val tableColor = eTableColor.text.toString().toInt()
                val tableMaterial = eTableMaterial.text.toString()
                val tableLength = eTableLength.text.toString().toDouble()
                val tableLegs = eTableLegs.text.toString().toInt()

                val cat = Cat(catName, catWeight, catColor, catHeight, catLength)
                val strength = tvCatStrength.text.toString() + cat.strength
                tvCatStrength.text = strength
                val table = Table(tableHeight, tableColor, tableMaterial, tableLength, tableLegs)

                jump(cat, table)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun jump(cat: Cat, table: Table) {
        val tableCharacteristic = table.legs * table.length / table.height / 5
        val result = if (cat.strength > tableCharacteristic)
            getString(R.string.jump_is_ok)
        else
            getString(R.string.jump_is_not_ok)
        binding.tvResultTask4.text = result
    }
}