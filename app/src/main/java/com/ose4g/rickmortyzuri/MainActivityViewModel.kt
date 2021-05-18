package com.ose4g.rickmortyzuri

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ose4g.rickmortyzuri.models.ApiResponse
import com.ose4g.rickmortyzuri.retrofit.RetrofitClass
import com.ose4g.rickmortyzuri.retrofit.RickAndMortyAPIService
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.await

class MainActivityViewModel:ViewModel()
{

    val service: RickAndMortyAPIService = RetrofitClass.getRetrofit()
        .create(RickAndMortyAPIService::class.java)

    fun getCharacters()
    {
//        val call = service.getResponseForPage()
//        call.enqueue(object : Callback<Response>{
//            override fun onFailure(call: Call<Response>, t: Throwable) {
//                Log.i("retrofit",t.message!!)
//            }
//
//            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
//                if(response.isSuccessful)
//                {
//                    val answer = response.body()!!
//
//                    for(i in 1..10) {
//                        Log.i("retrofit2", answer.results[i].names.toString())
//                    }
//                }
//            }
//
//        })

        viewModelScope.launch{

            val response:Response<ApiResponse> = service.getResponseForPage(2)
            if(response.isSuccessful)
            {
                Log.i("retrofit", response.body()?.results?.get(0)?.names.toString())
            }
            else
            {
                Log.i("retrofit", response.errorBody().toString())
            }

        }
    }
}