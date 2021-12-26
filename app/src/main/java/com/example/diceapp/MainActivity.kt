package com.example.diceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name: String = editText.text.toString()
    }

    override fun onStart() {
        super.onStart()

        button.setOnClickListener(View.OnClickListener {
            run {
                val name: String = editText.text.toString()
                when {
                    name.isEmpty() -> {
                        editText.error = "Please enter your name!"
                    }
                    name.length <= 2 -> {
                        editText.error = "Length of name should be more than 2 characters!"
                    }
                    else -> {
                        editText.error = null
                        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, DiceActivity::class.java)
                        intent.putExtra("NAME", name)
                        startActivity(intent)
                    }
                }
            }
        })
    }
}