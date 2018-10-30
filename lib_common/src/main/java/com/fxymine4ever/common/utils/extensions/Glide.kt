package com.fxymine4ever.common.utils.extensions

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

private val requestOptions by lazy {
    //暂定
}

fun Context.loadImage(url: String?,imageView:ImageView){
    url?.let {
        Glide.with(this)
                .load(it)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }
}