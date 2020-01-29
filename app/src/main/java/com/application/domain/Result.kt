package com.application.domain

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val error: Exception) : Result<Nothing>()
}

inline infix fun <T> Result<T>.doOnSuccess(f: (T) -> Unit): Result<T> {
    if (this is Result.Success) {
        f(data)
    }
    return this
}

inline infix fun <T> Result<T>.doOnError(f: (Exception) -> Unit): Result<T> {
    if (this is Result.Failure) {
        f(error)
    }
    return this
}


inline fun <T> safeCall(call: () -> T): Result<T> =
    try {
        Result.Success(call.invoke())
    } catch (exception: Exception) {
        Result.Failure(exception)
    }
