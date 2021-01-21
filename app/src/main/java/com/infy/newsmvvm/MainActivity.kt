package com.infy.newsmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.infy.newsmvvm.adapter.NewsAdapter
import com.infy.newsmvvm.application.MyApplication
import com.infy.newsmvvm.databinding.ActivityMainBinding
import com.infy.newsmvvm.model.NewsDetails
import com.infy.newsmvvm.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val factory = (this.applicationContext as MyApplication).viewModelFactory
        viewModel = ViewModelProviders.of(this, factory).get(NewsViewModel::class.java)
        mBinding.rcvDummy.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        adapter = NewsAdapter()
        mBinding.rcvDummy.adapter = adapter
        subscribeToNewsDetails()
    }

    private fun subscribeToNewsDetails() {
        viewModel.newsDetailsLiveData.observe(this,
            Observer {
                adapter.add(it as ArrayList<NewsDetails>)
            })
    }
}