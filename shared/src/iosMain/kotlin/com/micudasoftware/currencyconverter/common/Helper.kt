package com.micudasoftware.currencyconverter.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import com.micudasoftware.currencyconverter.di.appModule
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.CurrencyConverterScreen
import org.koin.core.context.startKoin

@OptIn(ExperimentalMaterialApi::class)
fun MainViewController() = ComposeUIViewController {
    BottomSheetNavigator(
        sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
    ) {
        Navigator(CurrencyConverterScreen)
    }
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}