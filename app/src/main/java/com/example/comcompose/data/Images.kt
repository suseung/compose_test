package com.example.comcompose.data

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("id") val id: String = "",
    @SerializedName("author") val author: String = "",
    @SerializedName("download_url") val imageUrl: String = ""
)
