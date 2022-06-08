package com.example.comcompose.data

import com.example.comcompose.api.ImageService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageRepository @Inject constructor(
    private val imageService: ImageService
) {
    suspend fun getImageList(pageNum: Int): List<Images> {
        return imageService.getImageList(page = pageNum)
    }
}