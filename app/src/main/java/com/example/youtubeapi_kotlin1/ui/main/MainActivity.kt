package com.example.youtubeapi_kotlin1.ui.main

import Items
import PlaylistAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi_kotlin1.base.BaseActivity
import com.example.youtubeapi_kotlin1.databinding.ActivityMainBinding
import com.example.youtubeapi_kotlin1.ui.detail.PlayListDetailActivity

class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }), OnPlaylistClick {

    private var viewModel: MainViewModel? = null
    private var adapter: PlaylistAdapter? = null
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = getViewBinding()
        val view = binding?.root

        setContentView(view)

    }

    override fun setupLiveData() {
        adapter = PlaylistAdapter(this)
        viewModel?.fetchPlayList()?.observe(this, {
            it?.items?.let { it1 -> adapter!!.setList(it1) }
            binding?.rvPlayLists?.adapter = adapter
            Toast.makeText(this, it?.kind.toString(), Toast.LENGTH_SHORT).show()
        })
    }

    override fun setupUI() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun showDisconnectState() {

    }

    override fun onPlaylist(items: Items) {
        var intent = Intent(this, PlayListDetailActivity::class.java)
        intent.putExtra("key", items.id)
        startActivity(intent)
        Log.e("TAG", "onPlaylist: ", )
    }

    override fun getViewBinding(): ActivityMainBinding {
       return ActivityMainBinding.inflate(layoutInflater)
    }
}