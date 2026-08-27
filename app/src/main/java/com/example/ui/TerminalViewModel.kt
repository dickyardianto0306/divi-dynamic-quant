package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.FierlApplication
import com.example.data.model.FierlReport
import com.example.data.repository.FierlRepository
import com.example.data.repository.FierlSeeder
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TerminalViewModel(private val repository: FierlRepository) : ViewModel() {

    val uiState: StateFlow<FierlReport?> = repository.latestReport
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    init {
        // Seed the database if empty
        viewModelScope.launch {
            if (!repository.hasData()) {
                val seedData = FierlSeeder.getInitialReport()
                repository.insertReport(seedData)
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as FierlApplication
                val repository = application.container.fierlRepository
                return TerminalViewModel(repository) as T
            }
        }
    }
}
