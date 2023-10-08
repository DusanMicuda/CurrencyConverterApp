package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model

/**
 * View state for Currency Converter Screen.
 *
 * @property currencyToConvert Currency to be converted.
 * @property convertedCurrency Converted currency.
 */
data class CurrencyConverterState(
    val currencyToConvert: CurrencyModel = CurrencyModel(),
    val convertedCurrency: CurrencyModel = CurrencyModel(),
)