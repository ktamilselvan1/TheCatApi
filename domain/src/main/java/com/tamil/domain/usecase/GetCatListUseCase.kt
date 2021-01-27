package com.tamil.domain.usecase

import com.tamil.domain.base.BaseUseCase
import com.tamil.domain.model.CatItem
import com.tamil.domain.model.Result
import com.tamil.domain.model.request.GetCatListRequest

interface GetCatListUseCase : BaseUseCase<GetCatListRequest, List<CatItem>> {
    override suspend operator fun invoke(param: GetCatListRequest): Result<List<CatItem>>

}