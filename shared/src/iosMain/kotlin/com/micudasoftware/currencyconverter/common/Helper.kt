package com.micudasoftware.currencyconverter.common

import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.navigator.Navigator
import com.micudasoftware.currencyconverter.di.appModule
import com.micudasoftware.currencyconverter.ui.screen.CurrencyRatesScreen
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    Navigator(CurrencyRatesScreen)
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}