package com.micudasoftware.currencyconverter.data.api.common

import io.ktor.http.ParametersBuilder
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

/**
 * Extension function for [ParametersBuilder] to append all properties of an object [data] of type [T].
 * The properties are appended as name-value pairs, where the name is the property name
 * and the value is the property value converted to a string.
 */
fun <T : Any> ParametersBuilder.appendAll(data: T) {
    data::class.memberProperties
        .filterIsInstance<KProperty1<T, *>>()
        .forEach { property ->
            property.get(data)?.let { append(property.name, it.toString()) }
        }
}
