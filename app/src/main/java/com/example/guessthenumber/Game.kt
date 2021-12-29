package com.example.guessthenumber

class Game {
    val maxAttempts: Int = 10
    var currentAttempts = maxAttempts
    var scores = 0

    fun play(userNumber: Int = 0, maxNum: Int = 10): Boolean {
        val numberToGuess = (0..maxNum).random()
        return userNumber == numberToGuess
    }

    fun restartGame() {
        currentAttempts = maxAttempts
    }
}