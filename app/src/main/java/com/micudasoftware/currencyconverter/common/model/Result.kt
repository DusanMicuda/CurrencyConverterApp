package com.micudasoftware.currencyconverter.common.model

/**
 * A sealed class representing the result of an operation.
 * It can either be a [Success] with a value of type [T], or an [Error].
 */
sealed class Result<out T> {

    /**
     * A data class representing a successful result with a value of type [T].
     */
    data class Success<out T>(val data: T) : Result<T>()

    /**
     * A class representing an error result.
     */
    class Error<out T> : Result<T>()
}

/**
 * Extension function to convert any object of type [T] to a [Result.Success] with the same value.
 */
fun <T : Any> T.toSuccess(): Result<T> {
    return Result.Success(this)
}
