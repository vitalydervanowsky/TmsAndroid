package com.example.tmsandroid.dz.dz15
// Создать класс Cat. Кот имеет свойства имя, вес, цвет, рост, длина и зависящее от веса,
// роста и длины свойство - сила.
// Необходимо создать функцию, определяющую высоту прыжка кота, зависящую от базовых параметров
// кота (вес, рост, высота).

class Cat(
    var name: String,
    var weight: Double,
    var color: Int,
    var height: Double,
    var length: Double
) {

    var strength = weight * height * length
}