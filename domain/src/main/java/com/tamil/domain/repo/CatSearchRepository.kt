package com.tamil.domain.repo

import com.tamil.domain.model.CatItem
import com.tamil.domain.model.Result

interface CatSearchRepository {
    suspend fun getCatListItems(page: Int, limit: Int): Result<List<CatItem>>
}