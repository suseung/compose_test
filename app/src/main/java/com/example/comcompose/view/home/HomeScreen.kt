package com.example.comcompose.view.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.comcompose.data.Images
import com.example.comcompose.view.ItemScreen
import kotlinx.coroutines.Job

@Composable
fun HomeScreen(
    list: List<Images>,
    navigateTo: () -> Unit,
    onClickAction: (Images) -> Unit,
    getMoreImageAction: () -> Job
) {
    val state = rememberLazyListState()
    val visibleSize = state.layoutInfo.visibleItemsInfo.size
    val visibleItemIndex = visibleSize + state.firstVisibleItemIndex
    LazyColumn(
        state = state,
        modifier = Modifier.padding(top = 30.dp)
    ) {
        items(list) {
            ItemScreen(it, navigateTo, onClickAction)
        }
        if(visibleItemIndex <= (list.lastIndex - visibleSize)) {
            getMoreImageAction()
        }
    }
}