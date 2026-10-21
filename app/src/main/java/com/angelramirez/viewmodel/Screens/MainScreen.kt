package com.angelramirez.viewmodel.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.angelramirez.viewmodel.CounterViewModel


@Composable
fun MainScreen(
    viewModel: CounterViewModel,
    onNavigateToDetail: () -> Unit
) {
    // Escuchamos los cambios de estado del ViewModel
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Vista 1: Principal", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Hola, ${state.userName}!", style = MaterialTheme.typography.titleLarge)
        Text(text = "Valor del Contador: ${state.counter}", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { viewModel.decrementCounter() }) {
                Text("- Disminuir")
            }
            Button(onClick = { viewModel.incrementCounter() }) {
                Text("+ Incrementar")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedButton(onClick = onNavigateToDetail) {
            Text("Ir a Vista 2")
        }
    }
}