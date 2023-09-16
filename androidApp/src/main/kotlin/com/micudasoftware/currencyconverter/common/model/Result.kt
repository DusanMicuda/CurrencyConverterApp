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

    /**
     * Executes the given [block] function if this [Result] is a success and returns this [Result].
     *
     * @param block A function to execute if this [Result] is a success.
     * @return This [Result].
     */
    inline fun onSuccess(block: (T) -> Unit): Result<T> {
        if (this is Success<T>) {
            block(this.data)
        }
        return this
    }

    /**
     * Executes the given [block] function if this [Result] is an error and returns this [Result].
     *
     * @param block A function to execute if this [Result] is an error.
     * @return This [Result].
     */
    inline fun onError(block: () -> Unit): Result<T> {
        if (this is Error<T>) {
            block()
        }
        return this
    }


    /**
     * Transforms a successful result of the [Result] by applying a [mapAction] function to it.
     * If this result is an error, the same error is returned.
     *
     * @param S The type of the mapped [Result] success value.
     * @param mapAction A function to transform the success value of this result.
     * @return A new [Result] instance with the transformed success value if this result is a success or the same error if this result is an error.
     */
    inline fun <S> map(mapAction: (T) -> S): Result<S> {
        return when (this) {
            is Success -> Success(mapAction(this.data))
            is Error -> Error()
        }
    }
}

/**
 * Extension function to convert any object of type [T] to a [Result.Success] with the same value.
 */
fun <T : Any> T.toSuccess(): Result<T> {
    return Result.Success(this)
}