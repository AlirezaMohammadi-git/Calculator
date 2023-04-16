package com.example.mycalculator.MainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mycalculator.repository.CalculatorListener
import javax.inject.Inject

class MainScreenViewModel : ViewModel() {
    fun getUpdateLiveData(): LiveData<Double> {
        return CalculatorListener.getResult()
    }
}