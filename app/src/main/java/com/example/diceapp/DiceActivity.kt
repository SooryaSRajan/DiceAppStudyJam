package com.example.diceapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dice.*
import kotlin.math.log
import kotlin.random.Random

class DiceActivity : AppCompatActivity() {

    var imageResId : Int = 0;
    val TAG = "Dice Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        imageView.setImageResource(R.drawable.dice_1)

        if(savedInstanceState != null){
            message_box.text = savedInstanceState.getString("MESSAGE")
            imageView.setImageResource(savedInstanceState.getInt("IMAGE"))
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()

        val name = intent.getStringExtra("NAME")

        roll_dice.setOnClickListener {
            when (Random.nextInt(from = 1, until = 7)) {
                1 -> {
                    imageResId = R.drawable.dice_1
                    imageView.setImageResource(R.drawable.dice_1)
                    message_box.text = "You got a 1, ${name}!"
                }
                2 -> {
                    imageResId = R.drawable.dice_2
                    imageView.setImageResource(R.drawable.dice_2)
                    message_box.text = "You got a 2, ${name}!"
                }
                3 -> {
                    imageResId = R.drawable.dice_3
                    imageView.setImageResource(R.drawable.dice_3)
                    message_box.text = "You got a 3, ${name}!"
                }
                4 -> {
                    imageResId = R.drawable.dice_4
                    imageView.setImageResource(R.drawable.dice_4)
                    message_box.text = "You got a 4, ${name}!"
                }
                5 -> {
                    imageResId = R.drawable.dice_5
                    imageView.setImageResource(R.drawable.dice_5)
                    message_box.text = "You got a 5, ${name}!"
                }
                6 -> {
                    imageResId = R.drawable.dice_6
                    imageView.setImageResource(R.drawable.dice_6)
                    message_box.text = "You got a 6, ${name}!"
                }
            }
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("MESSAGE", message_box.text as String?)
        outState.putInt("IMAGE", imageResId)
        Log.d(TAG, "onSaveInstanceState: ${message_box.text as String?}")
        Log.d(TAG, "onSaveInstanceState: $imageResId")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Destroyed")
    }
}