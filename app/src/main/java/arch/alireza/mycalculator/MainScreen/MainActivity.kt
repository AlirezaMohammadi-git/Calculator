package arch.alireza.mycalculator.MainScreen

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import arch.alireza.mycalculator.Utils.MainScreenViewModelFactory
import arch.alireza.mycalculator.databinding.ActivityMainBinding
import com.github.jairrab.calc.Calculator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainScreenViewModel: MainScreenViewModel

    @Inject
    lateinit var cal: Calculator


    var isEqualPressed = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainScreenViewModel = ViewModelProvider(
            this,
            MainScreenViewModelFactory()
        )[MainScreenViewModel::class.java]

        initializeNumbers()
        initializeOperations()

        mainScreenViewModel.getUpdateLiveData()
            .observe(this) {
                binding.txtAnswer.text = it.toString()
            }

        //<editor-fold desc="Handling configuration changes for txtOperation">
        if (savedInstanceState != null) {
            binding.txtOperation.text = savedInstanceState.getString("operation_text")
        }
        //</editor-fold>

        //<editor-fold desc="Set orientation to only portrait">
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        //</editor-fold>
    }

    private fun initializeOperations() {
        with(binding)
        {
            btnClear.setOnClickListener {
                txtOperation.text = ""
                cal.clear()
            }
            btnPlus.setOnClickListener {
                appendText("+")
                cal.pressPlus()
            }
            btnMinus.setOnClickListener {
                appendText("-")
                cal.pressMinus()
            }
            btnMultiple.setOnClickListener {
                appendText("x")
                cal.pressMultiply()
            }
            btnDivide.setOnClickListener {
                appendText("÷")
                cal.pressDivide()
            }
            btnPoin.setOnClickListener {
                appendText(".")
                cal.pressDecimal()
            }
            btnBackSpace.setOnClickListener {
                initializeBackSpace()
                cal.backSpace()
            }
            btnPercent.setOnClickListener {
                appendText("%")
                cal.pressPercent()
            }
        }
    }

    private fun initializeBackSpace() {
        if (binding.txtOperation.text.isNotEmpty()) {
            val newString =
                binding.txtOperation.text.substring(0, binding.txtOperation.text.length - 1)
            binding.txtOperation.text = newString

        }

    }

    private fun initializeNumbers() {
        with(binding) {
            btnNo0.setOnClickListener {
                appendText("0")
                cal.pressZero()
            }
            btnNo1.setOnClickListener {
                appendText("1")
                cal.pressOne()
            }
            btnNo2.setOnClickListener {
                appendText("2")
                cal.pressTwo()
            }
            btnNo3.setOnClickListener {
                appendText("3")
                cal.pressThree()
            }
            btnNo4.setOnClickListener {
                appendText("4")
                cal.pressFour()
            }
            btnNo5.setOnClickListener {
                appendText("5")
                cal.pressFive()
            }
            btnNo6.setOnClickListener {
                appendText("6")
                cal.pressSix()
            }
            btnNo7.setOnClickListener {
                appendText("7")
                cal.pressSeven()
            }
            btnNo8.setOnClickListener {
                appendText("8")
                cal.pressEight()
            }
            btnNo9.setOnClickListener {
                appendText("9")
                cal.pressNine()
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private fun appendText(newTxt: String) {
        if (isEqualPressed) {
            binding.txtOperation.text = newTxt
            isEqualPressed = false
            scrollToLatestText()
        } else if (!isEqualPressed) {
            val oldText = binding.txtOperation.text.toString()
            binding.txtOperation.text = oldText + newTxt
            scrollToLatestText()
        }
    }

    //scroll to the latest text in Operation TextView :
    private fun scrollToLatestText() {
        binding.HScrollViewOperation.postDelayed({
            binding.HScrollViewOperation.fullScroll(View.FOCUS_RIGHT)
        }, 100) // Delay of 100 milliseconds to allow the text to update
    }

    //Handling configuration changes :
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("operation_text", binding.txtOperation.text.toString())
    }

}



