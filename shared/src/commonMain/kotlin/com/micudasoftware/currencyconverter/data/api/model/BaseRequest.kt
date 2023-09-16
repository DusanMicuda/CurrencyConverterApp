package com.micudasoftware.currencyconverter.data.api.model

import kotlinx.serialization.json.JsonElement

/**
 * Interface representing base network api request.
 */
interface BaseRequest {

    /**
     * Function to get [JsonElement] form a kotlin data class.
     *
     * @return [JsonElement]
     */
    fun getJson(): JsonElement
}
