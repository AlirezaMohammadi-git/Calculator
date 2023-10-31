package arch.alireza.mycalculator.MainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import arch.alireza.mycalculator.repository.CalculatorListener

class MainScreenViewModel : ViewModel() {
    fun getUpdateLiveData(): LiveData<Double> {
        return CalculatorListener.getResult()
    }
}