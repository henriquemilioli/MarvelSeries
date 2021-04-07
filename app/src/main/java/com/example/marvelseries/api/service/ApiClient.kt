package com.example.marvelseries.api.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    private var instance: Retrofit? = null
    private fun getRetrofit(): Retrofit {
        if(instance == null) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
            instance = Retrofit
                .Builder()
                .baseUrl("http://gateway.marvel.com")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return instance as Retrofit
    }
    fun getSeriesService(): SeriesService =
        getRetrofit().create(SeriesService::class.java)

}