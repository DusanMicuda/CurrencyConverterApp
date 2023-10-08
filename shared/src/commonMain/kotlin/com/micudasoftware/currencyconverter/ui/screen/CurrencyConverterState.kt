package com.micudasoftware.currencyconverter.ui.screen

import com.micudasoftware.currencyconverter.ui.screen.model.CurrencyModel

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