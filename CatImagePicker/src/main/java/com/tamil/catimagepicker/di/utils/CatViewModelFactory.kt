package com.tamil.catimagepicker.di.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tamil.catimagepicker.di.ComponentInjection
import com.tamil.catimagepicker.ui.images.ImageSearchViewModel

internal class CatViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == ImageSearchViewModel::class.java) {
            return ImageSearchViewModel(
                ComponentInjection.provideCateImageUseCase()
            ) as T
        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }

    companion object {
        private var INSTANCE: CatViewModelFactory? = null
        fun getInstance(): CatViewModelFactory {
            if (INSTANCE == null) {
                INSTANCE = CatViewModelFactory()
            }
            return INSTANCE!!
        }
    }

}
