package com.example.youtubeapi_kotlin1.ui.playlist

import com.example.youtubeapi_kotlin1.model.Items
import PlaylistAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi_kotlin1.core.network.Status
import com.example.youtubeapi_kotlin1.ui.utils.InternetConnection
import com.example.youtubeapi_kotlin1.core.ui.BaseActivity
import com.example.youtubeapi_kotlin1.databinding.ActivityPlayListBinding
import com.example.youtubeapi_kotlin1.databinding.InternetConnectionBinding
import com.example.youtubeapi_kotlin1.ui.detail.PlayListDetailActivity

class PlayListActivity : BaseActivity<ActivityPlayListBinding>({ ActivityPlayListBinding.inflate(it) }),
    OnPlaylistClick {

    private var viewModel: PlayListViewModel? = null
    private var adapter: PlaylistAdapter? = null
    private var binding: ActivityPlayListBinding? = null

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
        viewModel?.fetchPlayList()?.observe(this, { response ->

            when(response.status){
                Status.LOADING -> {}

                Status.ERROR -> {
                    Toast.makeText(this, response.message,Toast.LENGTH_SHORT).show()
                }

                Status.SUCCESS -> {

                    if(response?.data != null) {
                        // Toast.makeText(this, response?.data?.kind.toString(), Toast.LENGTH_SHORT).show()
                        response.data.items.let { it1 -> adapter?.setList(it1) }
                        binding?.rvPlayLists?.adapter = adapter
                    }
                }
            }


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

    override fun getViewBinding(): ActivityPlayListBinding {
        return ActivityPlayListBinding.inflate(layoutInflater)
    }
}