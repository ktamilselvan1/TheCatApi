package com.tamil.data.di

import com.tamil.data.api.TheCatApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkModule {

    companion object {
        const val BASE_URL = "https://api.thecatapi.com/v1/images/"

        const val API_KEY = "9ea28de1-ba37-4324-b88e-c45f9680170a"

        private var INSTANCE: TheCatApi? = null

        fun getInstance(): TheCatApi {
            if (INSTANCE == null) {
                INSTANCE = provideRetrofit(provideOkHttpClient()).create(TheCatApi::class.java)
            }
            return INSTANCE!!
        }

        private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun provideOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            return OkHttpClient.Builder().apply {
                addInterceptor(interceptor)
                    .callTimeout(10, TimeUnit.SECONDS)
            }.build()
        }
    }

}