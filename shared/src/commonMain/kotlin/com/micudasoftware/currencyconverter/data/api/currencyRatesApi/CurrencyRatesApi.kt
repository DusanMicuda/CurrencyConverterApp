package com.micudasoftware.currencyconverter.data.api.currencyRatesApi

import com.micudasoftware.currencyconverter.common.model.Result
import com.micudasoftware.currencyconverter.data.api.common.ApiCaller
import com.micudasoftware.currencyconverter.data.api.common.HttpRoutes
import com.micudasoftware.currencyconverter.data.api.currencyRatesApi.model.CurrencyRatesReqDto
import com.micudasoftware.currencyconverter.data.api.currencyRatesApi.model.CurrencyRatesResDto

/**
 * A class representing the currency rates API.
 *
 * @property apiCaller The [ApiCaller] used to make API calls.
 */
class CurrencyRatesApi(
    private val apiCaller: ApiCaller,
) {

    /**
     * Retrieves the latest currency rates.
     *
     * @param request The [CurrencyRatesReqDto] containing the request parameters.
     * @return A [Result] containing either a [CurrencyRatesResDto] with the latest rates or an [Error].
     */
    suspend fun getLatestRates(request: CurrencyRatesReqDto): Result<CurrencyRatesResDto> {
        return apiCaller.callResult(url = HttpRoutes.LATEST_RATES, request = request)
    }
}

