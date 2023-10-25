package com.micudasoftware.currencyconverter.presentation.feature.currencyrates.model

import com.micudasoftware.currencyconverter.data.repository.model.Currency
import com.micudasoftware.currencyconverter.data.repository.model.CurrencyRate

/**
 * Data class representing view state for Currency Rates Screen.
 *
 * @property baseCurrency A base currency for which will be currency rates displayed.
 * @property currencies All available currencies.
 * @property rates The currency rates to be shown on screen.
 */
data class CurrencyRatesState(
    val baseCurrency: Currency? = null,
    val currencies: List<Currency> = emptyList(),
    val rates: List<CurrencyRate> = emptyList(),
)
