package com.johnpaulcas.rickandmorty.core.domain.util

import android.content.Context
import com.johnpaulcas.rickandmorty.R

enum class NetworkError: Error {
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN
}
