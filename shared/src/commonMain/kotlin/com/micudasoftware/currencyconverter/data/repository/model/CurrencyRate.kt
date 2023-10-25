package com.micudasoftware.currencyconverter.data.repository.model

import dev.icerock.moko.resources.desc.StringDesc

/**
 * Data class representing Currency rate.
 *
 * @property id The id of the currency.
 * @property rate The actual rate.
 * @property name The full name of the currency.
 */
data class CurrencyRate(
    val id: String,
    val rate: Double,
    val name: StringDesc?
)
