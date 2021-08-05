package com.example.tmsandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.tmsandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val menuFragment = MenuFragment()
        val fragmentManager = supportFragmentManager
        if (fragmentManager.findFragmentById(binding.container.id) == null)
            fragmentManager.beginTransaction()
                .add(binding.container.id, menuFragment)
                .commit()
    }
}