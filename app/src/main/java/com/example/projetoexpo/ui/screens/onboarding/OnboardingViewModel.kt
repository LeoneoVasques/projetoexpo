package com.example.projetoexpo.ui.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.projetoexpo.data.datastore.UserPreferencesRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class OnboardingTab {
    DIRECT_SELECTION,
    AI_QUIZ
}

data class OnboardingUiState(
    val userName: String = "",
    val selectedArea: String = "",
    val activeTab: OnboardingTab = OnboardingTab.DIRECT_SELECTION,
    val quizInterest: String = "",
    val quizWorkStyle: String = "",
    val isAnalyzingWithAi: Boolean = false,
    val aiRecommendationJustification: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
    val isFormValid: Boolean
        get() = userName.isNotBlank() && selectedArea.isNotBlank()
}

class OnboardingViewModel(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    fun onNameChanged(newName: String) {
        _uiState.update { currentState ->
            currentState.copy(
                userName = newName,
                errorMessage = null
            )
        }
    }

    fun onAreaSelected(areaName: String) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedArea = areaName,
                errorMessage = null,
                aiRecommendationJustification = null
            )
        }
    }

    fun onTabChanged(tab: OnboardingTab) {
        _uiState.update { it.copy(activeTab = tab, errorMessage = null) }
    }

    fun onQuizInterestSelected(interest: String) {
        _uiState.update { it.copy(quizInterest = interest) }
    }

    fun onQuizWorkStyleSelected(style: String) {
        _uiState.update { it.copy(quizWorkStyle = style) }
    }

    /**
     * Simula o algoritmo de Inteligência Artificial processando o questionário vocacional.
     */
    fun processAiQuiz() {
        val state = _uiState.value
        if (state.userName.isBlank()) {
            _uiState.update { it.copy(errorMessage = "Por favor, digite seu nome primeiro antes do diagnóstico.") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isAnalyzingWithAi = true, errorMessage = null) }
            delay(1200) // Simulação de processamento neural / IA

            val recommendedArea: String
            val justification: String

            when {
                state.quizInterest.contains("sites", ignoreCase = true) || state.quizInterest.contains("telas", ignoreCase = true) -> {
                    recommendedArea = "Desenvolvimento Front-end Web"
                    justification = "Identificamos forte afinidade visual e de lógica de interfaces com HTML, CSS e ecossistema React."
                }
                state.quizInterest.contains("servidores", ignoreCase = true) || state.quizInterest.contains("bancos", ignoreCase = true) -> {
                    recommendedArea = "Desenvolvimento Back-end & APIs"
                    justification = "Seu perfil foca em estruturas de dados sólidas, arquitetura de APIs e modelagem SQL."
                }
                state.quizInterest.contains("celular", ignoreCase = true) || state.quizInterest.contains("apps", ignoreCase = true) -> {
                    recommendedArea = "Desenvolvimento Mobile Android"
                    justification = "Compatibilidade perfeita com desenvolvimento nativo Kotlin e criação de apps móveis modernos."
                }
                state.quizInterest.contains("dados", ignoreCase = true) || state.quizInterest.contains("números", ignoreCase = true) -> {
                    recommendedArea = "Análise de Dados & BI"
                    justification = "Excelente perfil analítico para geração de dashboards executivos em Power BI e SQL."
                }
                state.quizInterest.contains("design", ignoreCase = true) || state.quizInterest.contains("ux", ignoreCase = true) -> {
                    recommendedArea = "Design UI/UX & Produto"
                    justification = "Alta orientação para experiência do usuário, empatia e prototipagem no Figma."
                }
                state.quizInterest.contains("segurança", ignoreCase = true) || state.quizInterest.contains("ciber", ignoreCase = true) -> {
                    recommendedArea = "Cibersegurança & SOC N1"
                    justification = "Aptidão para proteção de dados, mitigação de ameaças e conformidade LGPD."
                }
                else -> {
                    recommendedArea = "Suporte Técnico & Redes TI"
                    justification = "Excelente porta de entrada prática para diagnóstico de hardware, sistemas operacionais e redes."
                }
            }

            _uiState.update {
                it.copy(
                    isAnalyzingWithAi = false,
                    selectedArea = recommendedArea,
                    aiRecommendationJustification = justification,
                    activeTab = OnboardingTab.DIRECT_SELECTION
                )
            }
        }
    }

    fun saveAndProceed(onSuccess: () -> Unit) {
        val state = _uiState.value
        if (!state.isFormValid) {
            _uiState.update { it.copy(errorMessage = "Por favor, preencha seu nome e selecione uma área de carreira.") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                userPreferencesRepository.saveUserPreferences(
                    name = state.userName,
                    chosenArea = state.selectedArea
                )
                onSuccess()
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Erro ao salvar preferências: ${e.localizedMessage ?: "Tente novamente"}"
                    )
                }
            }
        }
    }

    companion object {
        fun provideFactory(
            userPreferencesRepository: UserPreferencesRepository
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return OnboardingViewModel(userPreferencesRepository) as T
            }
        }
    }
}
