package com.micudasoftware.currencyconverter.data.api.getCurrenciesApi

import com.micudasoftware.currencyconverter.common.model.Result
import com.micudasoftware.currencyconverter.data.api.common.ApiCaller
import com.micudasoftware.currencyconverter.data.api.common.HttpRoutes
import com.micudasoftware.currencyconverter.data.api.getCurrenciesApi.model.CurrencyDto

/**
 * Api to get all currencies.
 *
 * @param apiCaller The [ApiCaller] used to make API calls.
 */
class GetCurrenciesApi(
    private val apiCaller: ApiCaller
) {

    suspend fun getCurrencies(): Result<CurrencyDto> =
        apiCaller.callResult(url = HttpRoutes.CURRENCIES)
}
