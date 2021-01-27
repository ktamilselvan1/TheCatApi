package com.tamil.data.base

import com.tamil.domain.model.Result
import kotlinx.coroutines.coroutineScope

abstract class BaseRepository<T : Any>() {

    protected suspend fun fetchData(dataProvider: suspend () -> Result<T>): Result<T> {
        return coroutineScope {
            dataProvider()
        }
    }

    companion object {
        private const val GENERAL_NETWORK_ERROR = "Network Error"
    }
}