package br.edu.ifsp.dmo1.qualcombustivel

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var inputGasoline: EditText
    private lateinit var inputEthanol: EditText
    private lateinit var buttonCalc: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeVariables()

        buttonCalc.setOnClickListener(this)
    }

    private fun initializeVariables() {
        inputGasoline = findViewById(R.id.input_gasoline)
        inputEthanol = findViewById(R.id.input_ethanol)
        buttonCalc = findViewById(R.id.button)
        textResult = findViewById(R.id.text_result)
    }

    @Override
    override fun onClick(view: View) {
        if (view == buttonCalc) {
            if (checkInputValues()) {
                showResult()
            } else {
                showErrorMessage()
            }
        }
    }

    private fun showResult() {
        val gasolineValue = getInputValueConverted(inputGasoline)
        val ethanolValue = getInputValueConverted(inputEthanol)
        val proportion = ethanolValue / gasolineValue

        if (proportion > 0.70) {
            textResult.text = getString(R.string.result_gasoline)
            textResult.setTextColor(getColor(R.color.gasoline))
        } else  {
            textResult.text = getString(R.string.result_ethanol)
            textResult.setTextColor(getColor(R.color.ethanol))
        }
    }

    private fun showErrorMessage() {
        Toast.makeText(
            this, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
    }

    private fun getInputValueConverted(view: EditText) = view.text.toString().toDouble()

    private fun checkInputValues() = inputEthanol.text.isNotEmpty() &&
            inputGasoline.text.isNotEmpty()
}