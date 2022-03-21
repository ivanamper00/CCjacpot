package com.giaidac.common.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("android:scrUri")
fun srcUri(view: ImageView, uri: String){
    Glide.with(view.context)
        .load(uri)
        .into(view)
}