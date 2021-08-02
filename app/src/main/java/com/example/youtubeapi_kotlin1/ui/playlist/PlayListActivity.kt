package com.example.youtubeapi_kotlin1.ui.playlist

import Items
import PlaylistAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi_kotlin1.ui.utils.InternetConnection
import com.example.youtubeapi_kotlin1.base.BaseActivity
import com.example.youtubeapi_kotlin1.databinding.ActivityMainBinding
import com.example.youtubeapi_kotlin1.databinding.InternetConnectionBinding
import com.example.youtubeapi_kotlin1.ui.detail.PlayListDetailActivity

class PlayListActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }),
    OnPlaylistClick {

    private var viewModel: PlayListViewModel? = null
    private var adapter: PlaylistAdapter? = null
    private var binding: ActivityMainBinding? = null

    private var ui: InternetConnectionBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = getViewBinding()
        val view = binding?.root
        setContentView(view)
        ui =  binding?.interCon

    }

    override fun setupLiveData() {
        adapter = PlaylistAdapter(this)
        viewModel?.fetchPlayList()?.observe(this, {
            it?.items?.let { it1 -> adapter!!.setList(it1) }
            binding?.rvPlayLists?.adapter = adapter
            //Toast.makeText(this, it?.kind.toString(), Toast.LENGTH_SHORT).show()
        })
    }

    override fun setupUI() {
        viewModel = ViewModelProvider(this).get(PlayListViewModel::class.java)
    }

    override fun showDisconnectState() {
        val internetConnection = InternetConnection(context = this)

        internetConnection.observe(this, { isConnected ->
            if (isConnected) {
                binding?.rvPlayLists?.visibility = View.VISIBLE
                ui?.layoutDisconnect?.visibility = View.GONE

            } else{
                binding?.rvPlayLists?.visibility = View.GONE
                ui?.layoutDisconnect?.visibility = View.VISIBLE
            }
        })
    }

    override fun onPlaylist(items: Items) {
        val intent = Intent(this, PlayListDetailActivity::class.java)
        intent.putExtra("key", items.id)
        intent.putExtra("keyTitle", items.snippet.title)
        intent.putExtra("keyDescription", items.snippet.description)
        startActivity(intent)
    }

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}