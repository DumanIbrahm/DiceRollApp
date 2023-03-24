package com.example.dicerollapp
// Created by İbrahim Duman on 19.03.2023.
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.util.*
class MainActivity : AppCompatActivity() {
    private lateinit var resultImg1 : ImageView
    private lateinit var resultImg2 : ImageView
    private var imageRes1 : Int = 0
    private var imageRes2 : Int = 0
    var point = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollBtn : Button = findViewById(R.id.button)
        resultImg1 = findViewById(R.id.dice1)
        resultImg2 = findViewById(R.id.dice2)
        val scoreText : TextView = findViewById(R.id.textView)
        rollBtn.setOnClickListener{
            diceButton()
            val toast = Toast.makeText(this,"Dice Roller",Toast.LENGTH_LONG).show()
            if(imageRes1 == imageRes2){
                point += 1
                scoreText.text = "Score : ${point}"
            }
        }
    }
    private fun diceButton(){
        val dice1Int = Random().nextInt(6) + 1
        val dice2Int = Random().nextInt(6) + 1
         imageRes1 = imageRes(dice1Int)
         imageRes2 = imageRes(dice2Int)
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


