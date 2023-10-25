package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model

import com.micudasoftware.currencyconverter.data.repository.model.Currency

/**
 * Events that occurs on Currency converter screen.
 */
sealed class CurrencyConverterEvent {

    /**
     * Event to update value of currency that is going to be converted.
     *
     * @property value Value to update.
     */
    data class UpdateCurrencyToConvertValue(val value: String) : CurrencyConverterEvent()

    /**
     * Event that occurs when currency from which is going to be converted was selected.
     */
    data class OnSelectFromCurrency(
        val selectedCurrency: Currency,
    ) : CurrencyConverterEvent()

    /**
     * Event that occurs when currency to which is going to be converted was selected.
     */
    data class OnSelectToCurrency(
        val selectedCurrency: Currency,
    ) : CurrencyConverterEvent()

    /**
     * Event to turn currencies with each other.
     */
    data object TurnCurrencies : CurrencyConverterEvent()

    /**
     * Event to convert currency.
     */
    data object ConvertCurrency : CurrencyConverterEvent()
}
