package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model

import com.micudasoftware.currencyconverter.data.repository.model.Currency

/**
 * View state for Currency Converter Screen.
 *
 * @property currencies All available currencies.
 * @property fromCurrency Currency to be converted.
 * @property toCurrency Converted currency.
 */
data class CurrencyConverterState(
    val currencies: List<Currency> = emptyList(),
    val fromCurrency: CurrencyModel = CurrencyModel(),
    val toCurrency: CurrencyModel = CurrencyModel(),
)