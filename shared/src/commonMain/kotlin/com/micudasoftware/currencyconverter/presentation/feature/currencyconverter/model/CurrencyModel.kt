package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model

import com.micudasoftware.currencyconverter.data.repository.model.Currency

/**
 * Model for currency.
 *
 * @property value Value of the currency.
 * @property currency A Currency.
 */
data class CurrencyModel(
    val value: String = "",
    val currency: Currency? = null
)