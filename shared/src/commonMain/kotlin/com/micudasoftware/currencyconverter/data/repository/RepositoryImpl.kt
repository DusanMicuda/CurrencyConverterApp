package com.micudasoftware.currencyconverter.data.repository

import com.micudasoftware.currencyconverter.common.model.Result
import com.micudasoftware.currencyconverter.data.api.CurrencyRatesApi
import com.micudasoftware.currencyconverter.data.api.model.GetLatestRatesReqDto
import com.micudasoftware.currencyconverter.data.repository.model.Currency
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

/**
 * The implementation of [Repository].
 *
 * @property currencyRatesApi The api to get currency rates.
 */
class RepositoryImpl(
    private val currencyRatesApi: CurrencyRatesApi
) : Repository {

    override suspend fun getLatestRates(): Result<List<Currency>> =
        currencyRatesApi.getLatestRates(GetLatestRatesReqDto()).map { response ->
            val jsonElement = Json.encodeToJsonElement(response.rates)
            jsonElement.jsonObject.mapNotNull { property ->
                property.value.toString().toDoubleOrNull()?.let {
                    Currency(id = property.key, rate = it)
                }
            }
        }
}