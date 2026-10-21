package com.angelramirez.viewmodel.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.angelramirez.viewmodel.CounterViewModel

@Composable
fun DetailScreen(
    viewModel: CounterViewModel,
    onNavigateBack: () -> Unit
) {
    // Escuchamos EXACTAMENTE el mismo estado
    val state by viewModel.uiState.collectAsState()
    var textInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Vista 2: Detalle", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Estado compartido reflejado aquí:")
                Text(text = "Usuario: ${state.userName}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Contador actual: ${state.counter}", style = MaterialTheme.typography.bodyLarge)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = textInput,
            onValueChange = { textInput = it },
            label = { Text("Nuevo nombre") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (textInput.isNotBlank()) {
                viewModel.updateName(textInput)
                textInput = ""
            }
        }) {
            Text("Actualizar Estado del Nombre")
        }

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedButton(onClick = onNavigateBack) {
            Text("Volver a Vista 1")
        }
    }
}