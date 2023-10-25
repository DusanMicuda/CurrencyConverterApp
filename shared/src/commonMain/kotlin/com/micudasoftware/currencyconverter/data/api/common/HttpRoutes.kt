package com.micudasoftware.currencyconverter.data.api.common

/**
 * An object representing the HTTP routes for accessing the API.
 */
object HttpRoutes {

    /**
     * The base URL for the exchange rate API.
     */
    private const val BASE_URL = "https://api.frankfurter.app"

    /**
     * The URL for accessing the latest exchange rates.
     */
    const val LATEST_RATES = "$BASE_URL/latest"

    /**
     * The URL to get all currencies.
     */
    const val CURRENCIES = "$BASE_URL/currencies"
}
