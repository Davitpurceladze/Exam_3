package com.example.exam_3

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.exam_3.databinding.ActivityGameActivity5x5Binding

class GameActivity5x5 : AppCompatActivity() {

    enum class Turn {
        NOUGHT,
        CROSS
    }

    private var firstTurn = Turn.CROSS
    private var currentTurn = Turn.CROSS

    private var crossesScore = 0
    private var noughtsScore = 0

    private var boardList = mutableListOf<Button>()

    private lateinit var binding: ActivityGameActivity5x5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameActivity5x5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()
    }

    private fun initBoard() {
        with(boardList) {
            add(binding.a1)
            add(binding.a2)
            add(binding.a3)
            add(binding.a4)
            add(binding.a5)

            add(binding.b1)
            add(binding.b2)
            add(binding.b3)
            add(binding.b4)
            add(binding.b5)

            add(binding.c1)
            add(binding.c2)
            add(binding.c3)
            add(binding.c4)
            add(binding.c5)

            add(binding.d1)
            add(binding.d2)
            add(binding.d3)
            add(binding.d4)
            add(binding.d5)

            add(binding.e1)
            add(binding.e2)
            add(binding.e3)
            add(binding.e4)
            add(binding.e5)
        }

    }

    fun boardTapped(view: View) {
        if (view !is Button)
            return
        addToBoard(view)

        if (checkForVictory(GameActivity4x4.NOUGHT)) {

            noughtsScore++
            result("Noughts Win!")
        } else if (checkForVictory(GameActivity4x4.CROSS)) {

            crossesScore++
            result("Crosses Win!")
        }

        if (fullBoard()) {

            result("Draw")
        }

    }

    private fun checkForVictory(s: String): Boolean {
        //Horizontal Victory
        if (match(binding.a1, s) && match(binding.a2, s) && match(
                binding.a3,
                s
            ) && match(binding.a4, s) && match(binding.a5, s)
        )
            return true
        if (match(binding.b1, s) && match(binding.b2, s) && match(
                binding.b3,
                s
            ) && match(binding.b4, s) && match(binding.b5, s)
        )
            return true
        if (match(binding.c1, s) && match(binding.c2, s) && match(
                binding.c3,
                s
            ) && match(binding.c4, s) && match(binding.c5, s)
        )
            return true
        if (match(binding.d1, s) && match(binding.d2, s) && match(
                binding.d3,
                s
            ) && match(binding.d4, s) && match(binding.d5, s)
        )
            return true
        if (match(binding.e1, s) && match(binding.e2, s) && match(
                binding.e3,
                s
            ) && match(binding.e4, s) && match(binding.e5, s)
        )
            return true

        //Vertical Victory
        if (match(binding.a1, s) && match(binding.b1, s) && match(
                binding.c1,
                s
            ) && match(binding.d1, s) && match(binding.e1, s)
        )
            return true
        if (match(binding.a2, s) && match(binding.b2, s) && match(
                binding.c2,
                s
            ) && match(binding.d2, s) && match(binding.e2, s)
        )
            return true
        if (match(binding.a3, s) && match(binding.b3, s) && match(
                binding.c3,
                s
            ) && match(binding.d3, s) && match(binding.e3, s)
        )
            return true
        if (match(binding.a4, s) && match(binding.b4, s) && match(
                binding.c4,
                s
            ) && match(binding.d4, s) && match(binding.e4, s)
        )
            return true
        if (match(binding.a5, s) && match(binding.b5, s) && match(
                binding.c5,
                s
            ) && match(binding.d5, s) && match(binding.e5, s)
        )
            return true

        //Diagonal Victory
        if (match(binding.a1, s) && match(binding.b2, s) && match(
                binding.c3,
                s
            ) && match(binding.d4, s) && match(binding.e5, s)
        )
            return true
        if (match(binding.a5, s) && match(binding.b4, s) && match(
                binding.c3,
                s
            ) && match(binding.d2, s) && match(binding.e1, s)
        )
            return true

        return false
    }

    private fun match(button: Button, symbol: String): Boolean = button.text == symbol

    private fun result(title: String) {
        val message = "\nNoughts $noughtsScore\n\nCrosses $crossesScore"
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Reset")
            { _, _ ->
                resetBoard()

            }
            .setCancelable(false)
            .show()
    }

    private fun resetBoard() {
        for (button in boardList) {
            button.text = ""
        }

        if (firstTurn == Turn.NOUGHT)
            firstTurn = Turn.CROSS
        else if (firstTurn == Turn.CROSS)
            firstTurn = Turn.NOUGHT

        currentTurn = firstTurn
        setTurnLabel()
    }

    private fun fullBoard(): Boolean {
        for (button in boardList) {
            if (button.text == "")
                return false
        }
        return true
    }

    private fun addToBoard(button: Button) {
        if (button.text != "")
            return

        if (currentTurn == Turn.NOUGHT) {
            button.text = NOUGHT
            currentTurn = Turn.CROSS
        } else if (currentTurn == Turn.CROSS) {
            button.text = CROSS
            currentTurn = Turn.NOUGHT
        }
        setTurnLabel()
    }

    private fun setTurnLabel() {
        var turnText = ""
        if (currentTurn == Turn.CROSS)
            turnText = "Turn $CROSS"
        else if (currentTurn == Turn.NOUGHT)
            turnText = "Turn $NOUGHT"

        binding.turnTV.text = turnText
    }

    companion object {
        const val NOUGHT = "O"
        const val CROSS = "X"
    }


}