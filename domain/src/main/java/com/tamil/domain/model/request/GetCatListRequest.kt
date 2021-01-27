package com.tamil.domain.model.request

data class GetCatListRequest(
    val limit: Int,
    val page: Int,
    val order: String? = null
)
