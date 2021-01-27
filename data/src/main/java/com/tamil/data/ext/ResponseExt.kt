package com.tamil.data.ext

import com.tamil.domain.model.Failure
import com.tamil.domain.model.HttpError
import com.tamil.domain.model.Result
import com.tamil.domain.model.Success
import retrofit2.Response
import java.io.IOException

interface DomainMapper<T : Any> {
    fun mapToDomainModel(): T
}

inline fun <T : Any> Response<T>.onSuccess(action: (T) -> Unit): Response<T> {
    if (isSuccessful) body()?.run(action)
    return this
}

inline fun <T : Any> Response<T>.onFailure(action: (HttpError) -> Unit) {
    if (!isSuccessful) errorBody()?.run { action(HttpError(Throwable(message()), code())) }
}


/**
 * Use this when communicating only with the api service
 */
fun <T : DomainMapper<R>, R : Any> Response<List<T>>.getData(): Result<List<R>> {
    try {
        onSuccess {
            val responseData = it.map { map -> map.mapToDomainModel() }
            return Success(responseData)
        }
        onFailure { return Failure(it) }
        return Failure(HttpError(Throwable("GENERAL_NETWORK_ERROR")))
    } catch (e: IOException) {
        return Failure(HttpError(Throwable("GENERAL_NETWORK_ERROR")))
    }
}
