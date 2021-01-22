package com.infy.newsmvvm.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object AdapterUtil {
    @BindingAdapter("Image")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView).load(url)
            .error(android.R.drawable.ic_menu_gallery).into(imageView)
    }
}