package com.example.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInputEditText = findViewById<EditText>(R.id.userInputEditText).text
        val maxNumber = findViewById<EditText>(R.id.maxNumberEditText).text
        val rollButton = findViewById<Button>(R.id.rollButton)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val attemptsNum = findViewById<TextView>(R.id.attemptsNum)
        val scoresTextView = findViewById<TextView>(R.id.scores)
        val restartButton = findViewById<Button>(R.id.restartButton)

        val game = Game()

        attemptsNum.text = game.currentAttempts.toString()
        scoresTextView.text = game.scores.toString()

        rollButton.setOnClickListener {
            if (game.play(userInputEditText.toString().toInt(), maxNumber.toString().toInt())) {
                Toast.makeText(this, "Congrats, You Won!", Toast.LENGTH_SHORT).show()
                imageView.setImageResource(R.drawable.win_dice)
                game.scores = game.scores + 1
                scoresTextView.text = game.scores.toString()

            } else {
                Toast.makeText(this, "Sorry, You Lost!", Toast.LENGTH_SHORT).show()
                imageView.setImageResource(R.drawable.lose_dice)
                game.currentAttempts = game.currentAttempts - 1
                attemptsNum.text = game.currentAttempts.toString()
            }
        }

        restartButton.setOnClickListener {
            game.restartGame()
            attemptsNum.text = game.currentAttempts.toString()
            imageView.setImageResource(R.drawable.dice)
            game.scores = 0
            scoresTextView.text = game.scores.toString()
        }



    }


}