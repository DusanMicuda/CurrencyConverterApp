package com.micudasoftware.currencyconverter.data.repository

import com.micudasoftware.currencyconverter.common.model.Result
import com.micudasoftware.currencyconverter.data.api.currencyRatesApi.CurrencyRatesApi
import com.micudasoftware.currencyconverter.data.api.currencyRatesApi.model.CurrencyRatesReqDto
import com.micudasoftware.currencyconverter.data.api.getCurrenciesApi.GetCurrenciesApi
import com.micudasoftware.currencyconverter.data.repository.model.Currency
import com.micudasoftware.currencyconverter.data.repository.model.CurrencyRate

/**
 * The implementation of [Repository].
 *
 * @property currencyRatesApi The api to get currency rates.
 * @property getCurrenciesApi The api to get all currencies.
 */
class RepositoryImpl(
    private val currencyRatesApi: CurrencyRatesApi,
    private val getCurrenciesApi: GetCurrenciesApi,
) : Repository {

    override suspend fun getLatestRates(
        baseCurrency: Currency,
    ): Result<List<CurrencyRate>> =
        currencyRatesApi.getLatestRates(
            CurrencyRatesReqDto(from = baseCurrency.id)
        ).map { response ->
            response.toCurrencyRateList()
        }

    override suspend fun getCurrencies(): Result<List<Currency>> =
        getCurrenciesApi.getCurrencies().map { response ->
            response.toCurrencyList()
        }

    override suspend fun convertCurrency(
        from: Currency,
        to: Currency,
        amount: Double,
    ): Result<CurrencyRate> =
        currencyRatesApi.getLatestRates(
            CurrencyRatesReqDto(
                from = from.id,
                to = to.id,
                amount = amount
            )
        ).map { response ->
            response.toCurrencyRateList().first()
        }
}