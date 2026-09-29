package com.example.projetoexpo.ui.screens.trail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.projetoexpo.data.datastore.UserPreferencesRepository
import com.example.projetoexpo.data.repository.CareerMockRepository
import com.example.projetoexpo.domain.model.CareerTrail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

/**
 * Estado imutável da tela de Trilha / Timeline.
 */
data class TrailUiState(
    val userName: String = "Estudante",
    val trail: CareerTrail? = null,
    val completedStepIds: Set<String> = emptySet(),
    val progressFraction: Float = 0f,
    val showCertificate: Boolean = false,
    val isLoading: Boolean = true
) {
    val totalSteps: Int
        get() = trail?.steps?.size ?: 0

    val completedCount: Int
        get() = completedStepIds.size

    val isAllCompleted: Boolean
        get() = totalSteps > 0 && completedCount == totalSteps

    val totalHours: Int
        get() = trail?.steps?.sumOf { it.estimatedHours } ?: 0
}

/**
 * ViewModel da Trilha: Gerencia o progresso das etapas e emissão do certificado.
 */
class TrailViewModel(
    private val trailId: String,
    private val careerMockRepository: CareerMockRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TrailUiState())
    val uiState: StateFlow<TrailUiState> = _uiState.asStateFlow()

    init {
        loadUserAndTrail()
    }

    private fun loadUserAndTrail() {
        val foundTrail = careerMockRepository.getTrailById(trailId)
            ?: careerMockRepository.getAllTrails().firstOrNull()

        _uiState.update {
            it.copy(
                trail = foundTrail,
                isLoading = false
            )
        }

        userPreferencesRepository.userPreferencesFlow
            .onEach { preferences ->
                _uiState.update {
                    it.copy(userName = preferences.userName.ifBlank { "Estudante" })
                }
            }
            .launchIn(viewModelScope)
    }

    /**
     * Alterna a conclusão de um passo e recalcula o progresso.
     */
    fun toggleStepCompletion(stepId: String) {
        _uiState.update { currentState ->
            val updatedCompleted = currentState.completedStepIds.toMutableSet()
            if (updatedCompleted.contains(stepId)) {
                updatedCompleted.remove(stepId)
            } else {
                updatedCompleted.add(stepId)
            }

            val total = currentState.totalSteps
            val fraction = if (total > 0) updatedCompleted.size.toFloat() / total.toFloat() else 0f
            val allDone = total > 0 && updatedCompleted.size == total

            currentState.copy(
                completedStepIds = updatedCompleted,
                progressFraction = fraction,
                showCertificate = if (allDone && !currentState.isAllCompleted) true else currentState.showCertificate
            )
        }
    }

    fun openCertificate() {
        _uiState.update { it.copy(showCertificate = true) }
    }

    fun closeCertificate() {
        _uiState.update { it.copy(showCertificate = false) }
    }

    companion object {
        fun provideFactory(
            trailId: String,
            careerMockRepository: CareerMockRepository,
            userPreferencesRepository: UserPreferencesRepository
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return TrailViewModel(trailId, careerMockRepository, userPreferencesRepository) as T
            }
        }
    }
}
