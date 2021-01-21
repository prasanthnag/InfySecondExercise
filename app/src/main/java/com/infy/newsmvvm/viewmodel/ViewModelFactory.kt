package com.infy.newsmvvm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.infy.newsmvvm.repository.NewsRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory() : ViewModelProvider.NewInstanceFactory() {
    private lateinit var context: Context

    constructor(context: Context) : this() {
        this.context = context
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java))
            return NewsViewModel(NewsRepository(context)) as T
        return super.create(modelClass)
    }
}