package com.micudasoftware.currencyconverter.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.micudasoftware.currencyconverter.data.repository.model.Currency

/**
 * Preview for [CurrencyRatesScreen].
 */
@Preview
@Composable
fun CurrencyRatesScreenPreview() {
    CurrencyRatesScreen.Screen(
        viewState = CurrencyRatesState(
            listOf(
                Currency("EUR", 1.23),
                Currency("USD", 3.21),
                Currency("ABC", 2.31),
                Currency("CBD", 3.12),
                Currency("CZK", 1.32),
            )
        )
    )
}
