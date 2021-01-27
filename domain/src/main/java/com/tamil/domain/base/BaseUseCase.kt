package com.tamil.domain.base

import com.tamil.domain.model.Result


interface BaseUseCase<T : Any, R : Any> {
    suspend operator fun invoke(param: T): Result<R>
}