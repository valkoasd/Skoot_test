package com.valko.scoot.helpers

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun loadWithGlide(imageView: ImageView, path: String, centerCrop: Boolean = true) {

    val transformation = if (centerCrop) RequestOptions().centerCrop() else RequestOptions()

    Glide.with(imageView.context)
        .load(path)
        .apply(transformation)
        .into(imageView)
}