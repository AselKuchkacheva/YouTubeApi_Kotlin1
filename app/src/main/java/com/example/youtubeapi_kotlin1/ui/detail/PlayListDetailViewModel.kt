package com.example.youtubeapi_kotlin1.ui.detail

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

class PlayListDetailViewModel : BaseViewModel() {


    private var apiService: ApiService? = RetrofitClient.create()
    val data = MutableLiveData<PlayList>()

    fun fetchVideoByID(id: String) {

        apiService?.getVideoListFromPlaylist(Constant.PART, id, Constant.API_KEY, 10)
            ?.enqueue(object :
                Callback<PlayList> {

                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    data.value = response.body()

                }

                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    data.value = null
                }
            })
    }
}