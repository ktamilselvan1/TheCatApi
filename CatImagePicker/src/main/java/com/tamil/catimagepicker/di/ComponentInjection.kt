package com.tamil.catimagepicker.di

import android.content.Context
import com.tamil.catimagepicker.di.utils.CatViewModelFactory
import com.tamil.data.api.TheCatApi
import com.tamil.data.di.NetworkModule
import com.tamil.data.repo.CatSearchRepositoryImpl
import com.tamil.data.utils.Connectivity
import com.tamil.data.utils.ConnectivityImpl
import com.tamil.domain.repo.CatSearchRepository
import com.tamil.domain.usecase.GetCatListUseCase
import com.tamil.domain.usecase.GetCatListUseCaseImpl

internal object ComponentInjection {

    fun provideCateImageUseCase(): GetCatListUseCase {
        return GetCatListUseCaseImpl.getInstance(provideCatSearchRepository())
    }

    fun provideCatSearchRepository(): CatSearchRepository {
        return CatSearchRepositoryImpl.getInstance(provideTheCatApi())
    }

    fun provideTheCatApi(): TheCatApi {
        return NetworkModule.getInstance()
    }

    fun provideConnectivity(context: Context): Connectivity {
        return ConnectivityImpl.getInstance(context)
    }

    fun provideViewModelFactory() : CatViewModelFactory {
        return CatViewModelFactory.getInstance()
    }
}