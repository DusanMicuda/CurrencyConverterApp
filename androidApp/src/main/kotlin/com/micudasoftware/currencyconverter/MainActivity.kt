package com.micudasoftware.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.micudasoftware.currencyconverter.ui.screen.CurrencyConverterScreen
import com.micudasoftware.currencyconverter.ui.theme.CurrencyConverterTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterTheme {
                Navigator(CurrencyConverterScreen)
            }
        }
    }
}