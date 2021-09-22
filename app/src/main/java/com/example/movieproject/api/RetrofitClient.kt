package com.example.movieproject.api

import com.example.movieproject.utills.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var retrofit: Retrofit? = null

    private fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().
                 baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit!!
    }

    val apiService: MovieApi = getClient(BASE_URL).create(MovieApi::class.java)
}