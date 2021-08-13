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

        val id = binding.container.id
        val fm = supportFragmentManager
        if (fm.findFragmentById(id) == null)
            fm
                .beginTransaction()
                .add(id, LoginFragment())
                .commit()
    }
}