package com.example.comcompose.api

import com.example.comcompose.data.Images
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {
    @GET("/v2/list")
    suspend fun getImageList(
        @Query("page") page: Int = 1,
        @Query("limit") size: Int = 10
    ): List<Images>
}