package com.micudasoftware.currencyconverter.presentation.feature.currencyrates.model

import com.micudasoftware.currencyconverter.data.repository.model.Currency

/**
 * Events that occurs on Currency Rates Screen.
 */
sealed class CurrencyRatesEvent {

    /**
     * Event that occurs when base currency was selected.
     *
     * @property selectedCurrency A [Currency] that was selected.
     */
    data class OnBaseCurrencySelected(
        val selectedCurrency: Currency
    ): CurrencyRatesEvent()
}