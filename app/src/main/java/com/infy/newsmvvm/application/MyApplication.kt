package com.infy.newsmvvm.application

import android.app.Application
import com.infy.newsmvvm.viewmodel.ViewModelFactory

class MyApplication : Application() {

    private lateinit var application: MyApplication
    lateinit var viewModelFactory: ViewModelFactory
    override fun onCreate() {
        super.onCreate()
        application = this
        viewModelFactory = ViewModelFactory(applicationContext)
    }
}