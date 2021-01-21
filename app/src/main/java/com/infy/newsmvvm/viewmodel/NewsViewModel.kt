package com.infy.newsmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infy.newsmvvm.model.NewsDetails
import com.infy.newsmvvm.repository.NewsRepository

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    var newsDetailsLiveData: MutableLiveData<ArrayList<NewsDetails>> = MutableLiveData()

    init {
        getAllNewsDetails()
    }

    private fun getAllNewsDetails() {
        val list = newsRepository.getJSONItems()
        newsDetailsLiveData.value = list
    }
}