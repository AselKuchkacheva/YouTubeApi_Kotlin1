package com.example.youtubeapi_kotlin1

import android.app.Application
import com.example.youtubeapi_kotlin1.ui.detail.PlayListDetailRepository
import com.example.youtubeapi_kotlin1.ui.playlist.PlayListRepository

class App : Application() {

    val repository = PlayListRepository()
    val repositoryDetail = PlayListDetailRepository()
}