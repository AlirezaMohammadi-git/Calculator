package com.example.mycalculator.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.jairrab.calc.Calculator
import com.github.jairrab.calc.CalculatorUpdate

class CalculatorListener {
    companion object {
        private val liveRes = MutableLiveData<Double>()
        val calculatorListener = Calculator.Listener {
            when (it) {
                is CalculatorUpdate.Initializing -> {
                }
                is CalculatorUpdate.OnUpdate -> {
                    liveRes.value = it.result
                }
                is CalculatorUpdate.Error.DivideByZero -> {
                }
                is CalculatorUpdate.Error.InvalidKey -> {
                }
            }
        }
        fun getResult(): LiveData<Double> {
            return liveRes
        }
    }
}