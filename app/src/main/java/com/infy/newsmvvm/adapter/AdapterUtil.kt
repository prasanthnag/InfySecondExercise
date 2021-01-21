package com.infy.newsmvvm.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.infy.newsmvvm.model.NewsDetails

object AdapterUtil {

  /*  @BindingAdapter("NewsDetails")
    fun setNewsData(newsList:ArrayList<NewsDetails>, recyclerView: RecyclerView){
        val newsAdapter = recyclerView.adapter as NewsAdapter
        newsAdapter.add(newsList)
    }*/

    @BindingAdapter("Image")
    @JvmStatic fun loadImage(imageView: ImageView,url:String){
        Glide.with(imageView).load(url).into(imageView)
    }
}