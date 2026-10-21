package com.angelramirez.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Estado UI que representará la información de la app
data class UiState(
    val counter: Int = 0,
    val userName: String = "Usuario"
)

class CounterViewModel : ViewModel() {

    // Estado privado (solo el ViewModel puede modificarlo)
    private val _uiState = MutableStateFlow(UiState())

    // Estado público de solo lectura expuesto a las Views
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    // Métodos para alterar el estado (Lógica de negocio)
    fun incrementCounter() {
        _uiState.update { currentState ->
            currentState.copy(counter = currentState.counter + 1)
        }
    }

    fun decrementCounter() {
        _uiState.update { currentState ->
            currentState.copy(counter = currentState.counter - 1)
        }
    }

    fun updateName(newName: String) {
        _uiState.update { currentState ->
            currentState.copy(userName = newName)
        }
    }
}