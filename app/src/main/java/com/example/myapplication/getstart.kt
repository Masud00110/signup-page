package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class getstart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getstart)

        val button = findViewById<Button>(R.id.btn1)
        val button2 = findViewById<Button>(R.id.btn2)
        val button3 = findViewById<Button>(R.id.btn3)

        button.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)

        }

        button3.setOnClickListener {
            val intent = Intent(this, products::class.java)
            startActivity(intent)

        }
    }
}
