package com.example.youtubeapi_kotlin1.ui.playlist

import PlayList
import androidx.lifecycle.LiveData
import com.example.youtubeapi_kotlin1.App
import com.example.youtubeapi_kotlin1.base.BaseViewModel

class PlayListViewModel : BaseViewModel() {

    fun fetchPlayList(): LiveData<PlayList?> {

        return App().repository.fetchYoutubeApiPlayList()
    }
}