package com.micudasoftware.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.micudasoftware.currencyconverter.ui.screen.CurrencyRatesScreen
import com.micudasoftware.currencyconverter.ui.theme.CurrencyConverterTheme
import com.micudasoftware.currencyconverter.ui.viewmodel.CurrencyRatesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<CurrencyRatesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewState = viewModel.viewState.collectAsState()
            CurrencyConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CurrencyRatesScreen(viewState = viewState)
                }
            }
        }
    }
}