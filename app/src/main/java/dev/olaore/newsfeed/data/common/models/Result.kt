package dev.olaore.newsfeed.data.common.models

sealed class Result<T>(
    val data: T? = null,
    val message: String = ""
) {

    class Loading<T> : Result<T>()

    class Error<T>(message: String) : Result<T>(message = message)

    class Success<T>(data: T) : Result<T>(data)

}