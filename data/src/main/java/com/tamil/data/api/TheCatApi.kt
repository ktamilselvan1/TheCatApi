package com.tamil.data.api

import com.tamil.data.api.model.CatListItemApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatApi {

    @GET("search")
    suspend fun getCatListItems(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<CatListItemApiResponse>>


}