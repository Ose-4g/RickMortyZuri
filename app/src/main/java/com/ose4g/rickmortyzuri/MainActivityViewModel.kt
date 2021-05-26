package com.ose4g.rickmortyzuri

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.ose4g.rickmortyzuri.models.ApiResponse
import com.ose4g.rickmortyzuri.paging.RickMortyAPIPagingSource
import com.ose4g.rickmortyzuri.retrofit.RetrofitClass
import com.ose4g.rickmortyzuri.retrofit.RickAndMortyAPIService
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.await

class MainActivityViewModel:ViewModel()
{

    val service: RickAndMortyAPIService = RetrofitClass.getRetrofit()
        .create(RickAndMortyAPIService::class.java)

    val characters = Pager(PagingConfig(pageSize = 20)){
        RickMortyAPIPagingSource(service)
    }.flow.cachedIn(viewModelScope)

}