package com.example.youtubeapi_kotlin1.ui.detail

import Items
import PlaylistDetailAdapter
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi_kotlin1.base.BaseActivity
import com.example.youtubeapi_kotlin1.databinding.ActivityPlayListDetailBinding
import com.example.youtubeapi_kotlin1.ui.main.OnPlaylistClick

class PlayListDetailActivity : BaseActivity<ActivityPlayListDetailBinding>({ ActivityPlayListDetailBinding.inflate(it) }),
    OnPlaylistClick {

    private var binding: ActivityPlayListDetailBinding? = null
    private var viewModel: DetailViewModel? = null
    lateinit var adapter: PlaylistDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        val view = binding?.root
        setListeners()
        setContentView(view)
        setupRecycler()
        binding?.titleTv?.text = intent.getStringExtra("keyTitle")
        binding?.descTv?.text = intent.getStringExtra("keyDescription")
    }

    private fun setListeners() {
        binding?.arrowBack?.setOnClickListener {
            finish()
        }
    }

    private fun setupRecycler() {
        adapter = PlaylistDetailAdapter(this)
        binding?.videoListRecycler?.adapter = adapter
    }

    private fun getIntentPlayList() {
        val id = intent.getStringExtra("key")?: "not"

        viewModel?.fetchVideoByID(id)
       // Toast.makeText(baseContext, intent.getStringExtra("key"), Toast.LENGTH_SHORT).show()
    }

    override fun getViewBinding(): ActivityPlayListDetailBinding {
        return ActivityPlayListDetailBinding.inflate(layoutInflater)
    }

    override fun setupLiveData() {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        getIntentPlayList()
        viewModel?.data?.observe(this,{
            it?.items?.let { it1 -> adapter!!.setList(it1) }
        })
    }

    override fun setupUI() {

    }

    override fun showDisconnectState() {
    }

    override fun onPlaylist(items: Items) {
    }
}