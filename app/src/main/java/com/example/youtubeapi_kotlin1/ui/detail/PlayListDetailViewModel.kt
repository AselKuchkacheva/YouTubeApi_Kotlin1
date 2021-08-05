package com.example.youtubeapi_kotlin1.ui.detail

import PlayList
import androidx.lifecycle.LiveData
import com.example.youtubeapi_kotlin1.App
import com.example.youtubeapi_kotlin1.base.BaseViewModel

class PlayListDetailViewModel : BaseViewModel() {

    fun fetchVideoByID(id: String): LiveData<PlayList?> {

        return App().repositoryDetail.fetchVideoByID(id)

    }
}