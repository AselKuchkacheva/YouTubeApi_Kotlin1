package com.example.youtubeapi_kotlin1.ui.main

import PlayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi_kotlin1.base.BaseViewModel
import com.example.youtubeapi_kotlin1.data.`object`.Constant
import com.example.youtubeapi_kotlin1.data.remote.ApiService
import com.example.youtubeapi_kotlin1.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : BaseViewModel() {

    fun fetchPlayList(): LiveData<PlayList?> {
        return fetchYoutubeApiPlayList()
    }

    private var apiService: ApiService? = null

    private fun fetchYoutubeApiPlayList(): LiveData<PlayList?> {

        apiService = RetrofitClient.create()

        val data = MutableLiveData<PlayList?>()

        apiService?.fetchAllPlayList(Constant.API_KEY, Constant.PART, Constant.CHANNEL_ID)
            ?.enqueue(object :
                Callback<PlayList> {

                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {

                    data.value = response.body()

                }

                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    data.value = null
                }
            })

        return data
    }
}