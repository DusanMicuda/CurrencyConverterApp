package com.micudasoftware.currencyconverter.common

import androidx.compose.ui.window.ComposeUIViewController
import com.micudasoftware.currencyconverter.di.appModule
import com.micudasoftware.currencyconverter.presentation.App
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    App()
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}