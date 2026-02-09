package com.johnpaulcas.rickandmorty.core.domain.util

typealias EmptyResult<E> = Result<Unit, E>

sealed interface Result<out T, out E: Error> {
    data class Ok<out T>(val data: T): Result<T, Nothing>
    data class Err<out E: Error>(val error: E): Result<Nothing, E>
}

inline fun <T, E: Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when (this) {
        is Result.Err -> Result.Err(error)
        is Result.Ok -> Result.Ok(map(data))
    }
}

fun <T, E: Error> Result<T, E>.asEmptyResult(): EmptyResult<E> {
    return map {}
}
