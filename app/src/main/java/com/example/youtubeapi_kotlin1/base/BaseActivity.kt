package com.example.youtubeapi_kotlin1.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding>(val bindingFactory: (LayoutInflater) -> B) :
    AppCompatActivity() {

    private lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        setupUI()
        setupLiveData()
    }

    abstract fun getViewBinding(): B

    abstract fun setupLiveData() // внутри этого метода мы инициаллизируем все LiveData

    abstract fun setupUI() //внутри этого метода ты реализуем все view

    abstract fun showDisconnectState()

}

