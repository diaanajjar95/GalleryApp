package com.example.galleryapp.ui.base.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter

interface BindingAdapters {

    @BindingAdapter(
        "appImageUrl",
        requireAll = false
    )
    fun AppCompatImageView.setImage(
        imageUrl: String?
    )

}