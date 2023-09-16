package com.micudasoftware.currencyconverter.data.repository.model

/**
 * Data class representing Currency.
 *
 * @property id The id of the currency.
 * @property rate The actual rate.
 */
data class Currency(
    val id: String,
    val rate: Double
)
