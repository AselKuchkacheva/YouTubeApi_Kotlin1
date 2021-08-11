package com.example.youtubeapi_kotlin1.ui.playlist

import com.example.youtubeapi_kotlin1.model.PlayList
import androidx.lifecycle.LiveData
import com.example.youtubeapi_kotlin1.App
import com.example.youtubeapi_kotlin1.core.network.Resource
import com.example.youtubeapi_kotlin1.core.ui.BaseViewModel

class PlayListViewModel : BaseViewModel() {

    fun fetchPlayList(): LiveData<Resource<PlayList?>> {

        return App().repository.fetchYoutubeApiPlayList()
    }
}