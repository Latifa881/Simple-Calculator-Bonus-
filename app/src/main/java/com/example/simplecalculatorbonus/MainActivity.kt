package com.example.simplecalculatorbonus

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var tvResult:TextView
    lateinit var etNumber1:EditText
    lateinit var etNumber2:EditText
    lateinit var btAdd:Button
    lateinit var btSub:Button
    lateinit var btMultiply:Button
    lateinit var btDiv:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult=findViewById(R.id.tvResult)
        etNumber1=findViewById(R.id.etNumber1)
        etNumber2=findViewById(R.id.etNumber2)
        btAdd=findViewById(R.id.btAdd)
        btSub=findViewById(R.id.btSub)
        btMultiply=findViewById(R.id.btMultiply)
        btDiv=findViewById(R.id.btDiv)

        btAdd.setOnClickListener { checkIfEmpty('+') }
        btSub.setOnClickListener { checkIfEmpty('-') }
        btMultiply.setOnClickListener { checkIfEmpty('*') }
        btDiv.setOnClickListener { checkIfEmpty('/') }

    }
    fun checkIfEmpty(char:Char){
        val number1=etNumber1.text.toString()
        val number2=etNumber2.text.toString()

        if(number1.isNotEmpty()&&number2.isNotEmpty()){
            when(char){
                '+'->add(number1.toFloat(),number2.toFloat())
                '-'->sub(number1.toFloat(),number2.toFloat())
                '*'->multiply(number1.toFloat(),number2.toFloat())
                '/'->div(number1.toFloat(),number2.toFloat())
            }

        }else{
            Toast.makeText(this,"Enter two numbers",Toast.LENGTH_SHORT).show()
        }
    }
    fun add(number1: Float,number2: Float){
        etNumber1.setText("")
        etNumber2.setText("")
        tvResult.setText("The Result:\n $number1+$number2+${number1+number2}")
        tvResult.setTextColor(getResources().getColor(R.color.teal_700))
    }
    fun sub(number1: Float,number2: Float){
        etNumber1.setText("")
        etNumber2.setText("")
        tvResult.setText("The Result:\n $number1-$number2+${number1-number2}")
        tvResult.setTextColor(getResources().getColor(R.color.teal_700))
    }
    fun multiply(number1: Float,number2: Float){
        etNumber1.setText("")
        etNumber2.setText("")
        tvResult.setText("The Result:\n $number1*$number2+${number1*number2}")
        tvResult.setTextColor(getResources().getColor(R.color.teal_700))
    }
    fun div(number1: Float,number2: Float){
        etNumber1.setText("")
        etNumber2.setText("")
        if (number2!=0f)
        {tvResult.setText("The Result:\n $number1/$number2+${number1/number2}")
            tvResult.setTextColor(getResources().getColor(R.color.teal_700))}
        else{
            tvResult.setText("You Can't Divide By 0!")
            tvResult.setTextColor(Color.RED)

        }
    }
}