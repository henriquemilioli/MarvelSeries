package com.example.marvelseries.api.service

import com.example.marvelseries.model.Response
import com.example.marvelseries.model.Series
import retrofit2.http.GET
import retrofit2.http.Query

interface SeriesService {

    //listar
    @GET("v1/public/series")
    suspend fun all(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 20,
        @Query("ts") ts: String = "1",
        @Query("apikey") apikey: String = "bd936775caa3f5b72a1d43452a19b5bf",
        @Query("hash") hash: String = "8bbbfa10a8ecff03c19dda026cd9e397",

        ): List<Series>

}