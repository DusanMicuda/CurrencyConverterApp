package com.micudasoftware.currencyconverter.data.repository

import com.micudasoftware.currencyconverter.common.model.Result
import com.micudasoftware.currencyconverter.data.repository.model.Currency

/**
 * The main data repository.
 */
interface Repository {

    /**
     * Function to get latest currency rates.
     *
     * @return The [Result] with the [List] of [Currency].
     */
    suspend fun getLatestRates(): Result<List<Currency>>
}
