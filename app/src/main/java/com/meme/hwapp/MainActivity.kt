package com.meme.hwapp

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.meme.hwapp.base.BaseActivity
import com.meme.hwapp.databinding.ActivityMainBinding
import com.meme.hwapp.util.MainViewModelFactory

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var factory = MainViewModelFactory()
        var viewModel: MainViewModel = ViewModelProviders.of(this, factory).get(
            MainViewModel::class.java
        )

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        viewModel.getImgaesData().observe(this, Observer {
            viewModel.setData(it)
        })
    }
}
