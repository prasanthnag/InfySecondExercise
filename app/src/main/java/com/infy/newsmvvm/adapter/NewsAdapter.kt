package com.infy.newsmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.infy.newsmvvm.R
import com.infy.newsmvvm.databinding.ItemNewsBinding
import com.infy.newsmvvm.model.NewsDetails

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var newsDetails: ArrayList<NewsDetails> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_news,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsDetails[position])
    }

    override fun getItemCount(): Int {
        return newsDetails.size
    }

    fun add(list: ArrayList<NewsDetails>) {
        newsDetails = list
        notifyDataSetChanged()
    }


    class NewsViewHolder(private var binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsDetails) {
            binding.news = news
        }
    }
}