package com.example.tecsup.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val repository = CalculatorRepository()

    val errorMessage = MutableLiveData<String>()
    val average = MutableLiveData<String>()

    fun calculateAverage(practicaTeo1: String, practicaTeo2: String, practicaLab1: String, practicaLab2: String, practicaLab3: String, practicaLab4: String) {
        if (practicaTeo1.isEmpty() || practicaTeo2.isEmpty() || practicaLab1.isEmpty() || practicaLab2.isEmpty() || practicaLab3.isEmpty() || practicaLab4.isEmpty()) {
            errorMessage.value = "Verifique que todos los campos estén llenos"
            return
        }

        val result = repository.calculateAverage(practicaTeo1, practicaTeo2, practicaLab1, practicaLab2, practicaLab3, practicaLab4)

        if (result != null) {
            average.value = result.toString()
        } else {
            errorMessage.value = "Ingrese números válidos en todos los campos"
        }
    }
}