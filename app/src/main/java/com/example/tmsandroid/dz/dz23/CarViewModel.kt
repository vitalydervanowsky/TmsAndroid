package com.example.tmsandroid.dz.dz23

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarViewModel: ViewModel() {

    val carsLiveData = MutableLiveData<List<Car>>()
    val currentCarLiveData = MutableLiveData<Car>()

    private val data = listOf(
        Car("BMW", "Germany", "https://www.carlogos.org/car-logos/bmw-logo-1997-1200x1200.png"),
        Car("Opel", "Germany", "https://www.carlogos.org/logo/Opel-logo-2009-1920x1080.png"),
        Car("Lancia", "Italy", "https://www.carlogos.org/logo/Lancia-logo-2007-1920x1080.png"),
        Car("FIAT", "Italy", "https://www.carlogos.org/logo/Fiat-logo-2006-1920x1080.png"),
        Car("Ford", "USA", "https://www.carlogos.org/car-logos/ford-logo-2017.png"),
        Car("Mercedes-Benz", "Germany", "https://www.carlogos.org/logo/Mercedes-Benz-emblem-1926-1920x1080.png"),
        Car("Lamborghini", "Italy", "https://www.carlogos.org/car-logos/lamborghini-logo-1000x1100.png"),
        Car("Toyota", "Japan", "https://www.carlogos.org/car-logos/toyota-logo-1989-1400x1200.png"),
        Car("Tesla", "USA", "https://www.carlogos.org/car-logos/tesla-logo-2200x2800.png"),
        Car("Renault", "France", "https://www.carlogos.org/logo/Renault-logo-2015-2048x2048.png")
    )

    fun setCar(car: Car) {
        currentCarLiveData.value = car
    }

    fun setup() {
        carsLiveData.value = data
    }
}