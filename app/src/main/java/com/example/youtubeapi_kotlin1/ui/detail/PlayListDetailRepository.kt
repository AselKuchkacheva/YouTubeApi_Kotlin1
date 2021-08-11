package com.example.youtubeapi_kotlin1.ui.detail

import com.example.youtubeapi_kotlin1.model.PlayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapi_kotlin1.BuildConfig
import com.example.youtubeapi_kotlin1.core.network.Resource
import com.example.youtubeapi_kotlin1.data.remote.ApiService
import com.example.youtubeapi_kotlin1.data.remote.RetrofitClient
import com.example.youtubeapi_kotlin1.ui.utils.Constant
import kotlinx.coroutines.Dispatchers

class PlayListDetailRepository {

    private val apiService: ApiService = RetrofitClient.create()

    fun fetchVideoByID(id: String): LiveData<Resource<PlayList?>> = liveData(Dispatchers.IO) {

        Resource.loading(null)
        val response =
            apiService.getVideoListFromPlaylist(Constant.PART, id, BuildConfig.API_KEY, 10)
        emit(
            if (response.isSuccessful) Resource.success(response.body(), response.code())
            else Resource.error(response.message(), response.body(), response.code()
            )
        )
    }
}