package com.example.youtubeapi_kotlin1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.youtubeapi_kotlin1.R

class PlayListDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_list_detail)
        getIntentPlayList()
    }

    private fun getIntentPlayList() {
        Toast.makeText(baseContext, intent.getStringExtra("key"), Toast.LENGTH_SHORT).show()
    }
}