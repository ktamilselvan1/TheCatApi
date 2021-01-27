package com.tamil.domain.model

data class CatItem(

    val width: Int? = null,

    val categories: List<Categories?>? = null,

    val id: String? = null,

    val url: String? = null,

    val breeds: List<Any?>? = null,

    val height: Int? = null
)

data class Categories(

    val name: String? = null,

    val id: Int? = null
)
