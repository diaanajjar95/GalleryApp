package com.example.galleryapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.data.images.ImagesDataSource
import com.example.galleryapp.data.models.Hit
import com.example.galleryapp.data.remote.ApiDefaultResponse
import com.example.galleryapp.ui.base.BaseViewModel
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: ImagesDataSource
) : BaseViewModel() {

    private val _images: MutableLiveData<MutableList<Hit>> = MutableLiveData()
    val images: LiveData<MutableList<Hit>> = _images

    fun getImages() {
        onStartLoading()
        viewModelScope.launch {
            when (val result = repository.getImages()) {
                is ApiDefaultResponse.Success -> {
                    result.body?.hits?.let {
                        _images.value = it
                    }
                    onLoadSuccess()
                }
                is ApiDefaultResponse.Failed -> {
                    result.error.localizedMessage?.let { onLoadFailure(it) }
                }
            }
        }
    }

}