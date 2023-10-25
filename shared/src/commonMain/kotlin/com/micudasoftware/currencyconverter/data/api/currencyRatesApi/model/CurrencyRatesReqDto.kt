package com.micudasoftware.currencyconverter.data.api.currencyRatesApi.model

import com.micudasoftware.currencyconverter.data.api.common.model.BaseRequest
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement

/**
 * Request data for getting latest currency rates.
 *
 * @property base Three-letter currency code of preferred base currency.
 * @property symbols String with comma-separated currency codes to limit output currencies
 * @property amount The amount to be converted.
 * @property places Round numbers to decimal place.
 * @property source Source of data. Can be "ecb" for forex, or "crypto" for crypto currencies.
 */
@Serializable
data class CurrencyRatesReqDto(
    val from: String? = null,
    val to: String? = null,
    val amount: Double? = null,
): BaseRequest {

    override fun getJson(): JsonElement = Json.encodeToJsonElement(this)
}
