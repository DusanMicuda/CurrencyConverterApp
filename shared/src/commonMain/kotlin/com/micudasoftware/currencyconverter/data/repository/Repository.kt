package com.micudasoftware.currencyconverter.data.repository

import com.micudasoftware.currencyconverter.common.model.Result
import com.micudasoftware.currencyconverter.data.repository.model.Currency
import com.micudasoftware.currencyconverter.data.repository.model.CurrencyRate

/**
 * The main data repository.
 */
interface Repository {

    /**
     * Function to get latest currency rates.
     *
     * @return The [Result] with the [List] of [CurrencyRate].
     */
    suspend fun getLatestRates(
        baseCurrency: Currency,
    ): Result<List<CurrencyRate>>

    /**
     * Function to get all currencies.
     *
     * @return The [Result] with the [List] of [Currency].
     */
    suspend fun getCurrencies(): Result<List<Currency>>

    /**
     * Function to convert currency.
     *
     * @param from A [Currency] from which is going to be converted.
     * @param to A [Currency] to which is going to be converted.
     * @param amount An Amount that is going to be converted.
     * @return The [Result] with converted currency represented as [CurrencyRate].
     */
    suspend fun convertCurrency(
        from: Currency,
        to: Currency,
        amount: Double,
    ): Result<CurrencyRate>
}
