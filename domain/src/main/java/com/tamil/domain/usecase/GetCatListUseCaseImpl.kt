package com.tamil.domain.usecase

import com.tamil.domain.model.CatItem
import com.tamil.domain.model.Result
import com.tamil.domain.model.request.GetCatListRequest
import com.tamil.domain.repo.CatSearchRepository

class GetCatListUseCaseImpl(private val catRepository: CatSearchRepository) : GetCatListUseCase {
    override suspend fun invoke(param: GetCatListRequest): Result<List<CatItem>> {
        return catRepository.getCatListItems(param.page, param.limit)
    }

    companion object {
        private var INSTANCE: GetCatListUseCase? = null
        fun getInstance(catRepository: CatSearchRepository): GetCatListUseCase {
            if (INSTANCE == null) {
                INSTANCE = GetCatListUseCaseImpl(catRepository)
            }
            return INSTANCE!!
        }

    }
}