package com.example.tecsup.calculator

class CalculatorRepository {

    fun calculateAverage(practicaTeo1: String, practicaTeo2: String, practicaLab1: String, practicaLab2: String, practicaLab3: String, practicaLab4: String): Double? {
        val pt1 = practicaTeo1.toDoubleOrNull()
        val pt2 = practicaTeo2.toDoubleOrNull()
        val pl1 = practicaLab1.toDoubleOrNull()
        val pl2 = practicaLab2.toDoubleOrNull()
        val pl3 = practicaLab3.toDoubleOrNull()
        val pl4 = practicaLab4.toDoubleOrNull()

        if (pt1 != null && pt2 != null && pl1 != null && pl2 != null && pl3 != null && pl4 != null) {
            val sum = pt1 + pt2 + pl1 + pl2 + pl3 + pl4
            return sum / 6
        }

        return null
    }
}
