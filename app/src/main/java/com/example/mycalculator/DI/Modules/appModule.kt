package com.example.mycalculator.DI.Modules

import android.app.Application
import android.content.Context
import com.example.mycalculator.repository.CalculatorListener
import com.github.jairrab.calc.Calculator
import com.github.jairrab.calc.CalculatorType
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class appModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        val context = application.applicationContext
        return context
    }

    @Provides
    @Singleton
    fun provideCal(): Calculator {
        val listener = CalculatorListener.calculatorListener
        return Calculator.getInstance(CalculatorType.BASIC_MDAS,
            0.0,
            true,
            listener)
    }
}