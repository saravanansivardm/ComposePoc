package com.example.pocofdigivalapp.repository


sealed class Response<T> {
    class Success<T>(val data: T) : Response<T>() {
        inline fun <R> map(transform: (T) -> R): Success<R> {
            return Success(transform(data))
        }
    }

    class Failure<T>(val error: ApiFailure) : Response<T>() {
        inline fun <reified R> switch(): Failure<R> {
            return Failure(error)
        }
    }

    class NoNetwork<T>(val messageId: Int) : Response<T>() {
        inline fun <reified R> switch(): NoNetwork<R> {
            return NoNetwork(messageId)
        }
    }

    inline fun <reified R> mapSuccess(transform: (T) -> R): Response<R> {
        return when (this) {
            is Success -> map(transform)
            is Failure -> switch()
            is NoNetwork -> switch()
        }
    }
}

