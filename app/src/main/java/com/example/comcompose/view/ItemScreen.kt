package com.example.comcompose.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.comcompose.data.Images

@Composable
fun ItemScreen(
    item: Images,
    navigateTo: () -> Unit,
    onClickAction: (Images) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.Gray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
            .clickable {
                onClickAction(item)
                navigateTo()
            }
    ) {
        Row(
        ) {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .align(Alignment.CenterVertically)
                    .padding(start = 20.dp),
            )
            Text(
                text = "${item.author}  ${item.id}",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 20.dp, end = 20.dp)
            )
        }
    }
}