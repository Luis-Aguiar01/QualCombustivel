package br.edu.ifsp.dmo1.qualcombustivel

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputGasoline: EditText
    private lateinit var inputEthanol: EditText
    private lateinit var buttonCalc: Button
    private lateinit var textResult: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeVariables()
    }

    private fun initializeVariables() {
        inputGasoline = findViewById(R.id.input_gasoline)
        inputEthanol = findViewById(R.id.input_ethanol)
        buttonCalc = findViewById(R.id.button)
        textResult = findViewById(R.id.text_result)
    }

}