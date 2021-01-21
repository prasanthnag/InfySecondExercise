package com.infy.newsmvvm.viewmodel

import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.infy.newsmvvm.repository.Repository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory() :ViewModelProvider.NewInstanceFactory(){
private lateinit var context: Context

    constructor(context: Context) : this(){
        this.context = context
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java))
            return NewsViewModel(Repository(context)) as T
        return super.create(modelClass)
    }
}