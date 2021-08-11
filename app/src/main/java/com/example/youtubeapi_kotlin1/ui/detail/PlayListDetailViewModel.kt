package com.example.youtubeapi_kotlin1.ui.detail

import com.example.youtubeapi_kotlin1.model.PlayList
import androidx.lifecycle.LiveData
import com.example.youtubeapi_kotlin1.App
import com.example.youtubeapi_kotlin1.core.network.Resource
import com.example.youtubeapi_kotlin1.core.ui.BaseViewModel

class PlayListDetailViewModel : BaseViewModel() {

    fun fetchVideoByID(id: String): LiveData<Resource<PlayList?>> {

        return App().repositoryDetail.fetchVideoByID(id)

    }
}