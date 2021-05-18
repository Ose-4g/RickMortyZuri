package com.ose4g.rickmortyzuri.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitClass {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"
    
    private lateinit var retrofit:Retrofit
    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client = OkHttpClient.Builder().addInterceptor(interceptor)

    fun getRetrofit():Retrofit
    {
        if(!this::retrofit.isInitialized)
        {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
        }
        return retrofit
    }
}