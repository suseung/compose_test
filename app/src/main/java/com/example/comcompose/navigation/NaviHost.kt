package com.example.comcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.comcompose.view.detail.DetailScreen
import com.example.comcompose.view.home.HomeScreen
import com.example.comcompose.view.MainViewModel

@Composable
fun NaviHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    startDestination: String = Home
) {
    val viewModel: MainViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(Home) {
            HomeScreen(
                list = viewModel.imageList.value,
                navigateTo = { navController.navigate(Detail) },
                onClickAction = { currentImages -> viewModel.setUp(currentImages) },
                getMoreImageAction = { viewModel.getMoreImage() }
            )
        }
        composable(Detail) {
            DetailScreen(currentImages = viewModel.imageInfo.value)
        }
    }
}

const val Home = "home"
const val Detail = "detail"