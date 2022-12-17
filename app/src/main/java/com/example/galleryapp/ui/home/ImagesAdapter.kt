package com.example.galleryapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.galleryapp.data.models.Hit
import com.example.galleryapp.databinding.ViewItemImageBinding

class ImagesAdapter : RecyclerView.Adapter<ImagesVH>() {

    private var imagesList = mutableListOf<Hit>()
    private lateinit var binding: ViewItemImageBinding
    private var onItemClickListener: OnItemClickListener? = null

    fun setItems(items: List<Hit>) {
        imagesList.addAll(items)
        notifyItemRangeInserted(imagesList.size, items.size)
    }

    fun clear() {
        imagesList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesVH {
        binding = ViewItemImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImagesVH(binding)
    }

    override fun onBindViewHolder(holder: ImagesVH, position: Int) {
        holder.bind(imagesList[position])

        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClicked(it, imagesList[position], position)
        }

    }

    override fun getItemCount(): Int = imagesList.size

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener?) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClicked(view: View, item: Hit, position: Int)
    }

}