package com.example.comcompose.view

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.comcompose.navigation.NaviHost
import com.example.comcompose.ui.theme.ComcomposeTheme

@Composable
fun MainScreen() {
    val activity = (LocalContext.current as? Activity)
    ComcomposeTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "compose 연습"
                        )
                    },
                    backgroundColor = Color.Gray,
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                if (navController.backQueue.size <= 2) {
                                    activity?.finish()
                                } else {
                                    navController.popBackStack()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "back",
                                tint = Color.DarkGray,
                            )
                        }
                    }
                )
            }
        ) { padding ->
            NaviHost(
                navController = navController,
                modifier = Modifier
                    .padding(padding)
            )
        }
    }
}
