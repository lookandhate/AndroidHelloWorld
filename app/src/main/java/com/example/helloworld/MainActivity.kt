package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import javax.crypto.spec.IvParameterSpec

class MainActivity : AppCompatActivity() {
    var settedImage: Int = 0

    lateinit var diceImage: ImageView
    lateinit var RollButton: Button
    lateinit var CountUpButton: Button
    lateinit var ResetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        RollButton = findViewById(R.id.button_id)
        CountUpButton = findViewById(R.id.count_up_id)
        ResetButton = findViewById(R.id.reset_id)


        RollButton.setOnClickListener { rollDice() }
        CountUpButton.setOnClickListener { countUp() }
        ResetButton.setOnClickListener { Reset() }

    }

    fun getDrawableResource(numberOfImage: Int): Int {
        return when (numberOfImage) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    fun getImageNumberByResource(resource: Int): Int {
        return when (resource) {
            R.drawable.dice_1 -> 1
            R.drawable.dice_2 -> 2
            R.drawable.dice_3 -> 3
            R.drawable.dice_4 -> 4
            R.drawable.dice_5 -> 5
            R.drawable.dice_6 -> 6
            else -> 0
        }

    }

    private fun rollDice() {
        Toast.makeText(
                this, "Roll dice button clicked", Toast.LENGTH_SHORT
        ).show()

        val randomInt: Int = (1..6).random()
        val drawableResource = getDrawableResource(randomInt)

        settedImage = randomInt
        diceImage.setImageResource(drawableResource)
    }

    private fun countUp() {
        Toast.makeText(
                this, "CountUp dice button clicked", Toast.LENGTH_SHORT
        ).show()


        if (this.settedImage == 6) {
            settedImage = 1
            diceImage.setImageResource(getDrawableResource(settedImage))
        }

        else {
            settedImage += 1
            diceImage.setImageResource(getDrawableResource(settedImage))
        }



    }

    private fun Reset() {
        settedImage = 1
        diceImage.setImageResource(getDrawableResource(settedImage))
    }
}
