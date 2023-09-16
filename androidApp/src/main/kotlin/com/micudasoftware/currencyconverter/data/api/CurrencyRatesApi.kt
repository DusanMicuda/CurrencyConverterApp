package com.micudasoftware.currencyconverter.data.api

import com.micudasoftware.currencyconverter.common.model.Result
import com.micudasoftware.currencyconverter.data.api.common.ApiCaller
import com.micudasoftware.currencyconverter.data.api.common.HttpRoutes
import com.micudasoftware.currencyconverter.data.api.model.GetLatestRatesReqDto
import com.micudasoftware.currencyconverter.data.api.model.GetLatestRatesResDto

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
     * @param request The [GetLatestRatesReqDto] containing the request parameters.
     * @return A [Result] containing either a [GetLatestRatesResDto] with the latest rates or an [Error].
     */
    suspend fun getLatestRates(request: GetLatestRatesReqDto): Result<GetLatestRatesResDto> {
        return apiCaller.callResult(url = HttpRoutes.LATEST_RATES, request = request)
    }
}

