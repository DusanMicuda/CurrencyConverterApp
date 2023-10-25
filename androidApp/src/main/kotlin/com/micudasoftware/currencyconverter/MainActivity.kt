package com.micudasoftware.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import com.micudasoftware.currencyconverter.presentation.common.theme.CurrencyConverterTheme
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.CurrencyConverterScreen

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterTheme {
                BottomSheetNavigator(
                    sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                ) {
                    Navigator(CurrencyConverterScreen)
                }
            }
        }
    }
}