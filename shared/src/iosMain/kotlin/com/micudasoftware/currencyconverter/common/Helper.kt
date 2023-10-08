package com.micudasoftware.currencyconverter.common

import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.navigator.Navigator
import com.micudasoftware.currencyconverter.di.appModule
import com.micudasoftware.currencyconverter.ui.screen.CurrencyConverterScreen
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    Navigator(CurrencyConverterScreen)
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}