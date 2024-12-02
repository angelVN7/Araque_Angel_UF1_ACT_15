package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var operation: Int = 0
    var num1: Double = 0.0
    lateinit var textCal1: TextView
    lateinit var textCal2: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textCal1 = findViewById(R.id.tv1)
        textCal2 = findViewById(R.id.tv2)

        val clear: Button = findViewById(R.id.Clear)
        val result: Button = findViewById(R.id.Result)


        result.setOnClickListener {
            val num2: Double = textCal2.text.toString().toDouble()
            var answer: Double = 0.0

            when(operation){
                1 -> answer = num1 + num2
                2 -> answer = num1 - num2
                3 -> answer = num1 * num2
                4 -> answer = num1 / num2
            }

            textCal1.text = answer.toString()
            textCal2.text = ""
        }
        clear.setOnClickListener{
            textCal1.text = ""
            textCal2.text = ""
            num1 = 0.0
            operation = 0
        }

    }
    @SuppressLint("SetTextI18n")
    fun presionarBoton(view: View){

        val numero: String = textCal2.text.toString()

        when(view.id){
            R.id.But0 -> textCal2.text = numero + "0"
            R.id.But1 -> textCal2.text = numero + "1"
            R.id.But2 -> textCal2.text = numero + "2"
            R.id.But3 -> textCal2.text = numero + "3"
            R.id.But4 -> textCal2.text = numero + "4"
            R.id.But5 -> textCal2.text = numero + "5"
            R.id.But6 -> textCal2.text = numero + "6"
            R.id.But7 -> textCal2.text = numero + "7"
            R.id.But8 -> textCal2.text = numero + "8"
            R.id.But9 -> textCal2.text = numero + "9"
            if(numero.contains(".")){
                Toast.makeText(this, "Ya se ha agregado un punto decimal", Toast.LENGTH_LONG).show();
            }
            else
                R.id.Decimal -> textCal2.text = numero + "."
        }
    }
    fun selecOperation(view:View){
        num1 = textCal2.text.toString().toDouble()
        val num2: String = textCal2.text.toString()
        textCal2.text = ""
        when(view.id){
            R.id.Sum ->{
                textCal1.text = num2 + "+"
                operation = 1
            }
            R.id.Substract ->{
                textCal1.text = num2 + "-"
                operation = 2
            }
            R.id.Multiplication ->{
                textCal1.text = num2 + "x"
                operation = 3
            }
            R.id.Division ->{
                textCal1.text = num2 + "÷"
                operation = 4
            }
        }
    }
}