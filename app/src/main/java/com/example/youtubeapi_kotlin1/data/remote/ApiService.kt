package com.example.youtubeapi_kotlin1.data.remote

import com.example.youtubeapi_kotlin1.model.PlayList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/youtube/v3/playlists")
    suspend fun fetchAllPlayList(
        @Query("key") apiKey: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String
    ): Response<PlayList>

    @GET("youtube/v3/playlistItems")
    suspend fun getVideoListFromPlaylist(
        @Query("part")part : String,
        @Query("playlistId") playlistId: String,
        @Query("key") key : String,
        @Query("maxResults") maxResults : Int
    ) : Response<PlayList>
}