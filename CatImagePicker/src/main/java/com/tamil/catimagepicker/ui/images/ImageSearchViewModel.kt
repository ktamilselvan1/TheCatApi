package com.tamil.catimagepicker.ui.images

import com.tamil.catimagepicker.base.BaseViewModel
import com.tamil.catimagepicker.base.Error
import com.tamil.catimagepicker.base.Loading
import com.tamil.catimagepicker.base.Success
import com.tamil.domain.model.CatItem
import com.tamil.domain.model.onFailure
import com.tamil.domain.model.onSuccess
import com.tamil.domain.model.request.GetCatListRequest
import com.tamil.domain.usecase.GetCatListUseCase

internal class ImageSearchViewModel(
    private val catImageUseCase: GetCatListUseCase
) : BaseViewModel<List<CatItem>>() {

    fun getCatImages(page: Int, limit: Int) = executeUseCase {
        _viewState.postValue(Loading())
        val imageSearchRequest = GetCatListRequest(limit, page)
        catImageUseCase.invoke(imageSearchRequest)
            .onSuccess {
                _viewState.postValue(Success(it))
            }
            .onFailure {
                _viewState.postValue(Error(it.throwable))
            }
    }
}