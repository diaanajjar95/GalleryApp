package com.example.galleryapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.example.galleryapp.data.models.Hit
import com.example.galleryapp.databinding.ViewItemImageBinding

class ImagesVH(
    private val binding: ViewItemImageBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(hit: Hit) {
        binding.item = hit
    }

}