package com.infy.newsmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infy.newsmvvm.R
import com.infy.newsmvvm.application.MyApplication
import com.infy.newsmvvm.model.NewsDetails
import com.infy.newsmvvm.repository.Repository
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class NewsViewModel() : ViewModel() {
   private lateinit var mRepository: Repository

    constructor(repository: Repository) :this(){
        this.mRepository = repository
    }

    fun getAllNewsDetails(): LiveData<ArrayList<NewsDetails>>{
        return mRepository.getNewsData()
    }
}