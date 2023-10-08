package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model

/**
 * Model for currency.
 *
 * @property value Value of the currency.
 * @property currency Currency name.
 */
data class CurrencyModel(
    val value: String = "",
    val currency: String = ""
)