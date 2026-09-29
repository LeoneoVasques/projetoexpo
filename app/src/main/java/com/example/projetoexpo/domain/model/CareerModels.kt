package com.example.projetoexpo.domain.model

enum class SkillLevel(val label: String) {
    INICIANTE("Iniciante"),
    INTERMEDIARIO("Intermediário"),
    AVANCADO("Avançado")
}

/**
 * Representa uma vaga de estágio ou júnior simulada no protótipo.
 * (Alinhada à ODS 8 - Empregabilidade e Oportunidades Decentes).
 */
data class JobOpportunity(
    val id: String,
    val title: String,
    val company: String,
    val location: String, // ex: "100% Remoto", "Híbrido - São Paulo", "Presencial"
    val salary: String,   // ex: "R$ 2.200 - R$ 3.500"
    val matchScore: Int   // ex: 95 (% de match com a trilha)
)

/**
 * Representa uma etapa individual da trilha de aprendizagem.
 */
data class TrailStep(
    val id: String,
    val title: String,
    val description: String,
    val category: String, // ex: "Fundamentos", "Prática", "Projeto Final"
    val estimatedHours: Int,
    val isCompleted: Boolean = false,
    val resourceTip: String? = null,
    val resourceUrl: String? = null
)

/**
 * Representa a Trilha de Carreira completa com estatísticas de mercado.
 */
data class CareerTrail(
    val id: String,
    val title: String,
    val targetRole: String,
    val description: String,
    val category: String,
    val estimatedMonths: Int,
    val level: SkillLevel,
    val salaryRange: String, // Média salarial inicial
    val marketDemand: String, // Indicador de demanda no mercado
    val keySkills: List<String>, // Principais tecnologias/habilidades
    val steps: List<TrailStep>,
    val mockJobs: List<JobOpportunity> = emptyList() // Vagas simuladas
)
