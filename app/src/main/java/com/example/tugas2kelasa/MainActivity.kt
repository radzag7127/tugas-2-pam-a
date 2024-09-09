package com.example.tugas2kelasa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var operationGroup: RadioGroup
    private lateinit var buttonHitung: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Inisialisasi komponen UI
        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        operationGroup = findViewById(R.id.operationGroup)
        buttonHitung = findViewById(R.id.buttonHitung)

        buttonHitung.setOnClickListener {
            val number1 = input1.text.toString().toDoubleOrNull()
            val number2 = input2.text.toString().toDoubleOrNull()
            val selectedOperation = findViewById<RadioButton>(operationGroup.checkedRadioButtonId)

            if (number1 != null && number2 != null && selectedOperation != null) {
                val result = when (selectedOperation.text) {
                    "+" -> number1 + number2
                    "-" -> number1 - number2
                    "*" -> number1 * number2
                    "/" -> if (number2 != 0.0) number1 / number2 else null
                    else -> null
                }

                result?.let {
                    // Kirim hasil ke halaman kedua
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("result", it)
                    intent.putExtra("nim", "225150400111022")
                    intent.putExtra("nama", "Radyza Glagah Sudharma")
                    startActivity(intent)
                }
            }
        }
    }
}
