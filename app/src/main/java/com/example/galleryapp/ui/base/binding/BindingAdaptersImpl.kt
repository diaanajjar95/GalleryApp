package com.example.galleryapp.ui.base.binding

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.galleryapp.R

class BindingAdaptersImpl : BindingAdapters {

    override fun AppCompatImageView.setImage(imageUrl: String?) {
        Glide.with(this).load(imageUrl).error(R.drawable.ic_placeholder)
            .placeholder(R.drawable.ic_placeholder).into(this)
    }

}