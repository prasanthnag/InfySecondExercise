package com.infy.newsmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infy.newsmvvm.model.NewsDetails
import com.infy.newsmvvm.repository.Repository

class NewsViewModel() : ViewModel() {
    private lateinit var mRepository: Repository
    private var mutableLiveData: MutableLiveData<ArrayList<NewsDetails>> = MutableLiveData()

    constructor(repository: Repository) : this() {
        this.mRepository = repository
    }

    fun getAllNewsDetails(): LiveData<ArrayList<NewsDetails>> {
        val list = mRepository.getJSONItems()
        mutableLiveData.value = list
        return mutableLiveData
    }
}