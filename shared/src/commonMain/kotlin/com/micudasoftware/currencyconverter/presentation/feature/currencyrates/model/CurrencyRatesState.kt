package com.micudasoftware.currencyconverter.presentation.feature.currencyrates.model

import com.micudasoftware.currencyconverter.data.repository.model.CurrencyRate

/**
 * Data class representing view state for Currency Rates Screen.
 *
 * @property rates The currency rates to be shown on screen.
 */
data class CurrencyRatesState(
    val rates: List<CurrencyRate>
)
