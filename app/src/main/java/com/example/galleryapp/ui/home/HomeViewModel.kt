package com.example.galleryapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.data.images.ImagesDataSource
import com.example.galleryapp.data.models.Hit
import com.example.galleryapp.data.remote.ApiDefaultResponse
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: ImagesDataSource
) : ViewModel() {

    private val _images: MutableLiveData<MutableList<Hit>> = MutableLiveData()
    val images: LiveData<MutableList<Hit>> = _images

    private val _loading = LiveEvent<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _message = LiveEvent<String>()
    val message: LiveData<String> = _message

    fun getImages() {
        _loading.value = true
        viewModelScope.launch {
            when (val result = repository.getImages()) {
                is ApiDefaultResponse.Success -> {
                    result.body?.hits?.let {
                        _images.value = it
                    }
                }
                is ApiDefaultResponse.Failed -> {
                    _message.value = result.error.localizedMessage
                }
            }
            _loading.value = false
        }
    }

}