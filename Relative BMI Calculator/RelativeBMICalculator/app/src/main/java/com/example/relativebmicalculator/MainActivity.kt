package com.example.relativebmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var heightinput :EditText
    lateinit var weightinput :EditText
    lateinit var calculate_btn :Button
    lateinit var bminum :TextView
    lateinit var bmirange :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        heightinput = findViewById(R.id.heightinput)
        weightinput = findViewById(R.id.weightinput)
        calculate_btn = findViewById(R.id.calculate_btn)


        calculate_btn.setOnClickListener{
            val num1 = heightinput.text.toString().toDouble()
            val num2 = weightinput.text.toString().toDouble()
            val num3 = num1 / 100
            val num4 = num2 / (num3 * num3)

            setContentView(R.layout.activity_main2)

            bminum = findViewById(R.id.bminum)
            bmirange = findViewById(R.id.bmirange)
            bminum.text = "%.1f".format(num4)

            if(num4 < 18.5)
                bmirange.text = "You are UnderWeight"
            else if (num4 >=18.5 && num4 <25)
                bmirange.text = "You are in Healthy Weight Range"
            else if (num4 >=25 && num4 <30)
                bmirange.text = "You are OverWeight"
            else if (num4 > 30)
                bmirange.text = "Obese"


        }
    }
}