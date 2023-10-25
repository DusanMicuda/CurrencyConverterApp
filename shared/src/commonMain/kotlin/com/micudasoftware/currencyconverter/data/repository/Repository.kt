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
    suspend fun getLatestRates(): Result<List<CurrencyRate>>

    /**
     * Function to get all currencies.
     *
     * @return The Result with the [List] of [Currency].
     */
    suspend fun getCurrencies(): Result<List<Currency>>
}
