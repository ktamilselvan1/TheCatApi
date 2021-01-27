package com.tamil.data.api.model

import com.google.gson.annotations.SerializedName
import com.tamil.data.ext.DomainMapper
import com.tamil.domain.model.CatItem
import com.tamil.domain.model.Categories

data class CatListItemApiResponse(
    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("categories")
    val categories: List<CategoriesItem?>? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("breeds")
    val breeds: List<Any?>? = null,

    @field:SerializedName("height")
    val height: Int? = null
) : DomainMapper<CatItem> {
    override fun mapToDomainModel(): CatItem =
        CatItem(
            width,
            getMappedCategory(categories),
            id,
            url,
            breeds,
            height
        )

    private fun getMappedCategory(categories: List<CategoriesItem?>?): List<Categories?>? {
        val categoryItems = arrayListOf<Categories>()
        categories?.map {
            categoryItems.add(Categories(it?.name, it?.id))
        }
        return categoryItems
    }
}

data class CategoriesItem(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
) : DomainMapper<Categories> {
    override fun mapToDomainModel(): Categories =
        Categories(
            name,
            id
        )
}