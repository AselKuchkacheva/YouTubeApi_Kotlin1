package com.example.youtubeapi_kotlin1.ui.playlist

import PlayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapi_kotlin1.BuildConfig.API_KEY
import com.example.youtubeapi_kotlin1.data.remote.ApiService
import com.example.youtubeapi_kotlin1.data.remote.RetrofitClient
import com.example.youtubeapi_kotlin1.ui.utils.Constant
import kotlinx.coroutines.Dispatchers


class PlayListRepository {

    private val apiService: ApiService = RetrofitClient.create()

    fun fetchYoutubeApiPlayList(): LiveData<PlayList?> = liveData(Dispatchers.IO) {

        val response = apiService.fetchAllPlayList(API_KEY, Constant.PART, Constant.CHANNEL_ID)
        emit(if (response.isSuccessful) response.body() else PlayList(message = response.message()))
    }
}