package com.micudasoftware.currencyconverter.presentation.screen

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.micudasoftware.currencyconverter.data.repository.model.Currency
import com.micudasoftware.currencyconverter.presentation.common.theme.CurrencyConverterTheme
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.CurrencyRatesScreen
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.model.CurrencyRatesState

/**
 * Preview for [CurrencyRatesScreen].
 */
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun CurrencyRatesScreenPreview() {
    CurrencyConverterTheme {
        CurrencyRatesScreen.Screen(
            viewState = CurrencyRatesState(
                listOf(
                    Currency("EUR", 1.23),
                    Currency("USD", 3.21),
                    Currency("AFN", 2.31),
                    Currency("AED", 3.12),
                    Currency("CZK", 1.32),
                )
            )
        )
    }
}
