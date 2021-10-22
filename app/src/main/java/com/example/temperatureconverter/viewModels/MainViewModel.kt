package com.example.temperatureconverter.viewModels

import androidx.lifecycle.*
import com.example.temperatureconverter.util.Color
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {
    val fahrenheit = MutableStateFlow(0)
    val celsius : LiveData<Double> =
        Transformations.map(fahrenheit.asLiveData()) { fahrenheit ->
            convertFromFahrenheitToCelsius(fahrenheit)
        }

    val color=Transformations.map(celsius){
        getColor(it.toInt())
    }

    private fun convertFromFahrenheitToCelsius(fahrenheit:Int):Double {
        return (fahrenheit-32)*5/9.0
    }

    private fun getColor(degree:Int): Color {
        return when(degree){
            in Int.MIN_VALUE..-1 -> Color.BLUE
            in 0..20 ->Color.GREEN
            in 21..30 ->Color.YELLOW
            in 31..40 ->Color.ORANGE
            else -> Color.RED
        }
    }

}