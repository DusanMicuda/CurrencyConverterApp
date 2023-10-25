package com.micudasoftware.currencyconverter.data.api.currencyRatesApi.model

import kotlinx.serialization.Serializable

/**
 * Response data from getting latest currency rates.
 *
 * @property base Three-letter currency code of preferred base currency.
 * @property date Actual date of the given currency rates.
 * @property rates Currency rates.
 */
@Serializable
data class CurrencyRatesResDto(
    val base: String,
    val date: String,
    val rates: RatesDto,
)
