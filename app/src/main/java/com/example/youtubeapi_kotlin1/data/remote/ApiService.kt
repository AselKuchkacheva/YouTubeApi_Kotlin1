package com.example.youtubeapi_kotlin1.data.remote

import PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/youtube/v3/playlists")
    fun fetchAllPlayList(
        @Query("key") apiKey: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String
    ): Call<PlayList>

    @GET("youtube/v3/playlistItems")
    fun getVideoListFromPlaylist(
        @Query("part")part : String,
        @Query("playlistId") playlistId: String,
        @Query("key") key : String,
        @Query("maxResults") maxResults : Int
    ) : Call<PlayList>
}