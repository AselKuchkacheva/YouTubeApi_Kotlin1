package com.example.youtubeapi_kotlin1.ui.main

import PlaylistAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi_kotlin1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var viewModel: MainViewModel? = null
    private var adapter: PlaylistAdapter? = null
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root

        setContentView(view)
        setupUI()
        setupLiveData()
        showDisconnectState()

    }

    fun setupLiveData() {
        viewModel?.fetchPlayList()?.observe(this, {

            binding?.rvPlayLists?.apply {
                this.adapter = it?.let { it -> PlaylistAdapter(it) }
            }
            Toast.makeText(this, it?.kind.toString(), Toast.LENGTH_SHORT).show()
        })
    }

    fun setupUI() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    fun showDisconnectState() {

    }
}