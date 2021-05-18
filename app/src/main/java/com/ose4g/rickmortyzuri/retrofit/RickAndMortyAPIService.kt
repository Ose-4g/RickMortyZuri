package com.ose4g.rickmortyzuri.retrofit

import com.ose4g.rickmortyzuri.models.ApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyAPIService {
    @GET("character")
    suspend fun getResponseForPage(@Query("page") page:Int): Response<ApiResponse>
}