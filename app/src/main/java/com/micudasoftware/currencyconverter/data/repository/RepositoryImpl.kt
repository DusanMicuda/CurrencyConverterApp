package com.micudasoftware.currencyconverter.data.repository

import com.micudasoftware.currencyconverter.common.model.Result
import com.micudasoftware.currencyconverter.common.model.map
import com.micudasoftware.currencyconverter.data.api.CurrencyRatesApi
import com.micudasoftware.currencyconverter.data.api.model.GetLatestRatesReqDto
import com.micudasoftware.currencyconverter.data.repository.model.Currency
import kotlin.reflect.full.memberProperties

/**
 * The implementation of [Repository].
 *
 * @property currencyRatesApi The api to get currency rates.
 */
class RepositoryImpl(
    private val currencyRatesApi: CurrencyRatesApi
) : Repository {

    override suspend fun getLatestRates(): Result<List<Currency>>  =
        currencyRatesApi.getLatestRates(GetLatestRatesReqDto()).map { response ->
            response.rates::class.memberProperties.mapNotNull { property ->
                (property.call(response.rates) as? Double)?.let {
                    Currency(id = property.name, rate = it)
                }
            }
        }

}