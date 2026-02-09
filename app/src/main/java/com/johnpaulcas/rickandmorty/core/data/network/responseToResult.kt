package com.johnpaulcas.rickandmorty.core.data.network

import com.johnpaulcas.rickandmorty.core.domain.util.NetworkError
import com.johnpaulcas.rickandmorty.core.domain.util.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T, NetworkError> {
    return when (response.status.value) {
        in 200..299 -> {
            try {
                Result.Ok(response.body<T>())
            } catch (e: NoTransformationFoundException) {
                Result.Err(NetworkError.SERIALIZATION)
            }
        }

        408 -> Result.Err(NetworkError.REQUEST_TIMEOUT)
        429 -> Result.Err(NetworkError.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Err(NetworkError.SERVER_ERROR)
        else -> Result.Err(NetworkError.UNKNOWN)
    }
}