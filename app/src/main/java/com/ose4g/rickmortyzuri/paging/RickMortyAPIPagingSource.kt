package com.ose4g.rickmortyzuri.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ose4g.rickmortyzuri.models.ApiResponse
import com.ose4g.rickmortyzuri.models.Result
import com.ose4g.rickmortyzuri.retrofit.RickAndMortyAPIService
import retrofit2.Response
import java.lang.Error

class RickMortyAPIPagingSource(val service:RickAndMortyAPIService):PagingSource<Int,Result>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val position = params.key?: 1
            val response:ApiResponse = service.getResponseForPage(position).body()!!
            LoadResult.Page(
                data = response.results,
                prevKey = if(position>1) position-1 else null,
                nextKey = if(position<response.info.pages!!) position + 1 else null
            )
        }
        catch (e:Error)
        {
            LoadResult.Error(e)
        }


    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}