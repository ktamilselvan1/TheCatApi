package com.tamil.data.repo

import com.tamil.data.api.TheCatApi
import com.tamil.data.base.BaseRepository
import com.tamil.data.ext.getData
import com.tamil.domain.model.CatItem
import com.tamil.domain.model.Result
import com.tamil.domain.repo.CatSearchRepository

class CatSearchRepositoryImpl(
    private val theCatApi: TheCatApi
) : BaseRepository<List<CatItem>>(), CatSearchRepository {
    override suspend fun getCatListItems(page: Int, limit: Int): Result<List<CatItem>> {
        return fetchData(
            dataProvider = {
                theCatApi.getCatListItems(page, limit).getData()
            }
        )
    }

    companion object {
        private var INSTANCE: CatSearchRepository? = null
        fun getInstance(
            theCatApi: TheCatApi
        ): CatSearchRepository {
            if (INSTANCE == null) {
                INSTANCE = CatSearchRepositoryImpl(theCatApi)
            }
            return INSTANCE!!
        }
    }

}