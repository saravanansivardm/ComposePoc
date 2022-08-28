package com.example.pocofdigivalapp.unitconvertor

import androidx.lifecycle.ViewModel

class ConverterViewModel : ViewModel() {

    fun getConversion() = listOf(
        Conversion(1, "Pounds to kilograms", "lbs", "kg", 0.453592),
        Conversion(1, "kilograms to Pounds", "kg", "lbs", 2.20462),
        Conversion(1, "Yards to Meters", "yd", "m", 0.9144),
        Conversion(1, "Meters to Yards", "m", "yd", 1.09361),
        Conversion(1, "Miles to kilometers", "mi", "km", 1.60934),
        Conversion(1, "kilometers to Miles", "km", "mi", 0.621371),
    )
}