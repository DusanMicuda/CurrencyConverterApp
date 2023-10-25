package com.micudasoftware.currencyconverter.data.repository.model

import dev.icerock.moko.resources.desc.StringDesc

/**
 * Data class representing Currency.
 *
 * @property id The id of the currency.
 * @property name The full name of the currency.
 */
data class Currency(
    val id: String,
    val name: StringDesc?,
)
