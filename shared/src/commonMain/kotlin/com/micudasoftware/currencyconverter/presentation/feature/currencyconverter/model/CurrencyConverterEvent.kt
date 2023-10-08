package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model

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
     * Event to to open selector for currency that is going to be converted.
     */
    data object OpenCurrencyToConvertSelector : CurrencyConverterEvent()

    /**
     * Event to open selector for currency to which is going to be converted.
     */
    data object OpenConvertedCurrencySelector : CurrencyConverterEvent()

    /**
     * Event to turn currencies with each other.
     */
    data object TurnCurrencies : CurrencyConverterEvent()

    /**
     * Event to convert currency.
     */
    data object ConvertCurrency : CurrencyConverterEvent()
}
