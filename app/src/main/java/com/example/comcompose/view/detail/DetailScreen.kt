package com.example.comcompose.view.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.comcompose.data.Images

@Composable
fun DetailScreen(currentImages: Images) {
    Column {
        AsyncImage(
            model = currentImages.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(300.dp, 300.dp)
                .padding(
                    start = 20.dp, end = 20.dp,
                    top = 20.dp, bottom = 20.dp
                )
        )
        Text(
            text = "${currentImages.author}  ${currentImages.id}",
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}