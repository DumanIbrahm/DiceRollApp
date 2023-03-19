package com.example.dicerollapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Button
import java.util.*
class MainActivity : AppCompatActivity() {
    private lateinit var resultImg1 : ImageView
    private lateinit var resultImg2 : ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollBtn : Button = findViewById(R.id.button)
        resultImg1 = findViewById(R.id.dice1)
        resultImg2 = findViewById(R.id.dice2)
        rollBtn.setOnClickListener{
            diceButton()
        }
    }
    private fun diceButton(){
        val dice1Int = Random().nextInt(6) + 1
        val dice2Int = Random().nextInt(6) + 1
        val imageRes1 = imageRes(dice1Int)
        val imageRes2 = imageRes(dice2Int)
        resultImg1.setImageResource(imageRes1)
        resultImg2.setImageResource(imageRes2)
    }
    private fun imageRes(diceInt : Int) : Int{
        val result = when(diceInt){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        return result
    }
}

