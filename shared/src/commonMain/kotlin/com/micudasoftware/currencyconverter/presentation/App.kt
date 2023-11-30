package com.micudasoftware.currencyconverter.presentation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.micudasoftware.currencyconverter.presentation.common.theme.CurrencyConverterTheme
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.CurrencyConverterScreen

/**
 * Composable function representing whole Currency Converter App.
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App() {
    CurrencyConverterTheme {
        BottomSheetNavigator(
            sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
        ) {
            TabNavigator(CurrencyConverterScreen())
        }
    }
}