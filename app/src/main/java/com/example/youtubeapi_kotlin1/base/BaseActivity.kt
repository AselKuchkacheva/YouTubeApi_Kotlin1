package com.example.youtubeapi_kotlin1.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(private val layout: Int): AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        showDisconnectState()
        setupUI()
        setupLiveData()
    }

    abstract fun setupLiveData() // внутри этого метода мы инициаллизируем все LiveData

    abstract fun setupUI() //внутри этого метода ты реализуем все view

    abstract fun showDisconnectState()
}