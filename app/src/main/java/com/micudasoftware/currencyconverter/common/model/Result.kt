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

/**
 * Transforms a successful result of the [Result] by applying a [mapAction] function to it.
 * If this result is an error, the same error is returned.
 *
 * @param T The type of the original [Result] success value.
 * @param S The type of the mapped [Result] success value.
 * @param mapAction A function to transform the success value of this result.
 * @return A new [Result] instance with the transformed success value if this result is a success or the same error if this result is an error.
 */
inline fun <T, S> Result<T>.map(mapAction: (T) -> S): Result<S> {
    return when (this) {
        is Result.Success -> Result.Success(mapAction(this.data))
        is Result.Error -> Result.Error()
    }
}