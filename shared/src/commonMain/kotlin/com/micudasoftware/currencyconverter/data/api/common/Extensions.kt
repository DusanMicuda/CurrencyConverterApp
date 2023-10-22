package com.micudasoftware.currencyconverter.data.api.common

import com.micudasoftware.currencyconverter.data.api.model.BaseRequest
import io.ktor.http.ParametersBuilder
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive


/**
 * Extension function for [ParametersBuilder] to append all properties of an object [data].
 * The properties are appended as key-value pairs, where the key is the property name
 * and the value is the property value converted to a string.
 */
fun ParametersBuilder.appendAll(data: BaseRequest) {
    data.getJson().jsonObject
        .forEach { append(it.key, it.value.jsonPrimitive.content) }
}