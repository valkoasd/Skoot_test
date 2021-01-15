package com.valko.scoot.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.valko.scoot.helpers.loadWithGlide

@BindingAdapter("image", "centerCrop")
fun ImageView.setLogo(url: String, centerCrop: Boolean){
    loadWithGlide(this, url, centerCrop)
}
