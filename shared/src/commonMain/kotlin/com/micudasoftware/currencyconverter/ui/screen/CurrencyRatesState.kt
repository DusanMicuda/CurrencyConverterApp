package com.micudasoftware.currencyconverter.ui.screen

import com.micudasoftware.currencyconverter.data.repository.model.Currency

/**
 * Data class representing view state for Currency Rates Screen.
 *
 * @property rates The currency rates to be shown on screen.
 */
data class CurrencyRatesState(
    val rates: List<Currency>
)
