package com.example.exam_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exam_3.databinding.ActivityGameBinding
import com.example.exam_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        binding.tv3x3.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        binding.tv4x4.setOnClickListener {
            val intent = Intent(this, GameActivity4x4::class.java)
            startActivity(intent)
        }

        binding.tv5x5.setOnClickListener {
            val intent = Intent(this, GameActivity5x5::class.java)
            startActivity(intent)
        }
    }
}