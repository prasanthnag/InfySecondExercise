package com.infy.newsmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.infy.newsmvvm.model.NewsDetails
import com.infy.newsmvvm.repository.Repository

class NewsViewModel() : ViewModel() {
    private lateinit var mRepository: Repository

    constructor(repository: Repository) : this() {
        this.mRepository = repository
    }

    fun getAllNewsDetails(): LiveData<ArrayList<NewsDetails>> {
        return mRepository.getNewsData()
    }
}