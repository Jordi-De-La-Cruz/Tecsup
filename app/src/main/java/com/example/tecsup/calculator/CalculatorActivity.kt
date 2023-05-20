package com.example.tecsup.calculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tecsup.R
import android.widget.EditText

class CalculatorActivity : AppCompatActivity() {

    private lateinit var viewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        val edtPracticaTeo1 = findViewById<EditText>(R.id.edtPracticaTeo1)
        val edtPracticaTeo2 = findViewById<EditText>(R.id.edtPracticaTeo2)
        val edtPracticaLab1 = findViewById<EditText>(R.id.edtPracticaLab1)
        val edtPracticaLab2 = findViewById<EditText>(R.id.edtPracticaLab2)
        val edtPracticaLab3 = findViewById<EditText>(R.id.edtPracticaLab3)
        val edtPracticaLab4 = findViewById<EditText>(R.id.edtPracticaLab4)

        val btnCalcular = findViewById<Button>(R.id.calcular)
        btnCalcular.setOnClickListener {
            val practicaTeo1 = edtPracticaTeo1.text.toString()
            val practicaTeo2 = edtPracticaTeo2.text.toString()
            val practicaLab1 = edtPracticaLab1.text.toString()
            val practicaLab2 = edtPracticaLab2.text.toString()
            val practicaLab3 = edtPracticaLab3.text.toString()
            val practicaLab4 = edtPracticaLab4.text.toString()

            viewModel.calculateAverage(practicaTeo1, practicaTeo2, practicaLab1, practicaLab2, practicaLab3, practicaLab4)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.errorMessage.observe(this, Observer {
            showAlert("Error", it)
        })

        viewModel.average.observe(this, Observer {
            val averageText = findViewById<EditText>(R.id.promedio)
            averageText.setText(it)
        })
    }

    private fun showAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setCancelable(false)
        builder.setPositiveButton("Aceptar") { _, _ -> }
        val alertDialog = builder.create()
        alertDialog.show()
    }
}
