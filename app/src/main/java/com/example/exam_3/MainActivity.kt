package com.example.exam_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        binding.startGame.setOnClickListener {
            startGame()
        }
    }

    private fun startGame() {
        if (binding.game3x3.isChecked) {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        } else if (binding.game4x4.isChecked) {
            val intent = Intent(this, GameActivity4x4::class.java)
            startActivity(intent)
        } else if (binding.game5x5.isChecked) {
            val intent = Intent(this, GameActivity5x5::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "choose one of board games to start game", Toast.LENGTH_SHORT)
                .show()
        }
    }
}