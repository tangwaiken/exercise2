package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.Math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calbutton: Button = findViewById(R.id.buttonCalculate)
        calbutton.setOnClickListener { cal() }
        val resetButton: Button = findViewById(R.id.buttonReset)
        resetButton.setOnClickListener {reset()}
    }
    private fun cal(){
        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
        val h: EditText = findViewById(R.id.editTextHeight)
        val w: EditText = findViewById(R.id.editTextWeight)
        val height: Double = h.text.toString().toDouble()
        val weight: Double = w.text.toString().toDouble()
        val result: Double = weight / pow((height/100),2.0)
        val img: ImageView = findViewById(R.id.imageViewProfile)
        val bmi: TextView = findViewById(R.id.textViewBMI)
        if(result<18.5){
            img.setImageResource(R.drawable.under)
        }
        else if(result>=18.5&&result<25){
            img.setImageResource(R.drawable.normal)
        }
        else{
            img.setImageResource(R.drawable.over)
        }
        bmi.setText("BMI : " + String.format("%.2f", result))
    }
    private fun reset(){
        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
        val h: EditText = findViewById(R.id.editTextHeight)
        val w: EditText = findViewById(R.id.editTextWeight)
        val img: ImageView = findViewById(R.id.imageViewProfile)
        val bmi: TextView = findViewById(R.id.textViewBMI)

        h.setText("")
        w.setText("")
        img.setImageResource(R.drawable.empty)
        bmi.setText(R.string.bmi)
    }
}
