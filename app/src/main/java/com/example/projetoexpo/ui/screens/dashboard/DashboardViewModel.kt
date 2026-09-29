package com.example.projetoexpo.ui.screens.dashboard

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
import kotlinx.coroutines.launch

/**
 * Estado da tela de Dashboard com suporte a busca e filtros por categoria.
 */
data class DashboardUiState(
    val userName: String = "",
    val chosenArea: String = "",
    val recommendedTrail: CareerTrail? = null,
    val allTrails: List<CareerTrail> = emptyList(),
    val filteredOtherTrails: List<CareerTrail> = emptyList(),
    val selectedCategory: String = "Todas",
    val searchQuery: String = "",
    val isLoading: Boolean = true
)

class DashboardViewModel(
    private val userPreferencesRepository: UserPreferencesRepository,
    private val careerMockRepository: CareerMockRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    init {
        observeUserPreferences()
    }

    private fun observeUserPreferences() {
        userPreferencesRepository.userPreferencesFlow
            .onEach { preferences ->
                val recommended = careerMockRepository.getRecommendedTrail(preferences.chosenArea)
                val allTrails = careerMockRepository.getAllTrails()

                _uiState.update { current ->
                    val others = allTrails.filter { it.id != recommended.id }
                    current.copy(
                        userName = preferences.userName.ifBlank { "Estudante" },
                        chosenArea = preferences.chosenArea.ifBlank { "Tecnologia" },
                        recommendedTrail = recommended,
                        allTrails = allTrails,
                        filteredOtherTrails = filterTrails(others, current.selectedCategory, current.searchQuery),
                        isLoading = false
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    fun onSearchQueryChanged(query: String) {
        _uiState.update { current ->
            val recommendedId = current.recommendedTrail?.id
            val others = current.allTrails.filter { it.id != recommendedId }
            current.copy(
                searchQuery = query,
                filteredOtherTrails = filterTrails(others, current.selectedCategory, query)
            )
        }
    }

    fun onCategorySelected(category: String) {
        _uiState.update { current ->
            val recommendedId = current.recommendedTrail?.id
            val others = current.allTrails.filter { it.id != recommendedId }
            current.copy(
                selectedCategory = category,
                filteredOtherTrails = filterTrails(others, category, current.searchQuery)
            )
        }
    }

    private fun filterTrails(trails: List<CareerTrail>, category: String, query: String): List<CareerTrail> {
        return trails.filter { trail ->
            val matchesCategory = when (category) {
                "Todas" -> true
                "Dev & Software" -> trail.category.contains("Desenvolvimento", ignoreCase = true) || trail.category.contains("Mobile", ignoreCase = true)
                "Dados & BI" -> trail.category.contains("Dados", ignoreCase = true)
                "Infra & Segurança" -> trail.category.contains("Infraestrutura", ignoreCase = true) || trail.category.contains("Segurança", ignoreCase = true) || trail.category.contains("Cloud", ignoreCase = true)
                "Design & Produto" -> trail.category.contains("Design", ignoreCase = true)
                "Marketing & Negócios" -> trail.category.contains("Comunicação", ignoreCase = true)
                else -> true
            }

            val matchesQuery = query.isBlank() ||
                trail.title.contains(query, ignoreCase = true) ||
                trail.targetRole.contains(query, ignoreCase = true) ||
                trail.keySkills.any { it.contains(query, ignoreCase = true) }

            matchesCategory && matchesQuery
        }
    }

    fun switchArea(newArea: String) {
        viewModelScope.launch {
            userPreferencesRepository.updateChosenArea(newArea)
        }
    }

    fun resetSession(onComplete: () -> Unit) {
        viewModelScope.launch {
            userPreferencesRepository.clearUserPreferences()
            onComplete()
        }
    }

    companion object {
        fun provideFactory(
            userPreferencesRepository: UserPreferencesRepository,
            careerMockRepository: CareerMockRepository
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DashboardViewModel(userPreferencesRepository, careerMockRepository) as T
            }
        }
    }
}
