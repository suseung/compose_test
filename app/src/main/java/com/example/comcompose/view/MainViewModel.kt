package com.example.comcompose.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comcompose.data.ImageRepository
import com.example.comcompose.data.Images
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val imageRepository: ImageRepository
) : ViewModel() {
    private val _imageList: MutableState<List<Images>> = mutableStateOf(emptyList())
    val imageList: State<List<Images>> get() = _imageList

    private val _imageInfo: MutableState<Images> = mutableStateOf(Images())
    val imageInfo: State<Images> get() = _imageInfo

    private val _currentPage: MutableState<Int> = mutableStateOf(1)
    val currentPage: State<Int> get() = _currentPage

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> get() = _isLoading

    init {
        getImage()
    }
    private fun getImage() = viewModelScope.launch {
        val res = withContext(Dispatchers.IO) {
            imageRepository.getImageList(1)
        }
        _imageList.value = res
    }

    fun getMoreImage() = viewModelScope.launch {
        if (isLoading.value) {
            _isLoading.value = false
            val index = currentPage.value + 1
            _currentPage.value = index
            val prevList = imageList.value
            val res = withContext(Dispatchers.IO) {
                imageRepository.getImageList(index)
            }
            _imageList.value = (prevList.toMutableList() + res)
            _isLoading.value = true
        }
    }

    fun setUp(images: Images) {
        _imageInfo.value = images
    }
}
