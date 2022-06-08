package com.example.comcompose

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color.Companion.Red
import com.example.comcompose.ui.theme.ComcomposeTheme
import com.example.comcompose.view.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
            ComcomposeTheme {
                window?.statusBarColor = Color.GRAY
            }
        }
    }
}
