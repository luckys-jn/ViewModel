package com.angelramirez.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import com.angelramirez.viewmodel.Screens.DetailScreen
import com.angelramirez.viewmodel.Screens.MainScreen

class MainActivity : ComponentActivity() {

    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Control simple de cuál Vista mostrar
            var currentScreen by remember { mutableStateOf(1) }

            if (currentScreen == 1) {
                MainScreen(
                    viewModel = counterViewModel,
                    onNavigateToDetail = { currentScreen = 2 }
                )
            } else {
                DetailScreen(
                    viewModel = counterViewModel,
                    onNavigateBack = { currentScreen = 1 }
                )
            }
        }
    }
}