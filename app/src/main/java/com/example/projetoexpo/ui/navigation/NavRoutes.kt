package com.example.projetoexpo.ui.navigation

/**
 * Definição centralizada de todas as rotas de navegação do App.
 * (Equivalente ao arquivo de constantes de rotas ou caminhos no React Router / Next.js).
 */
sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Onboarding : Screen("onboarding")
    data object Dashboard : Screen("dashboard")
    data object Trail : Screen("trail/{trailId}") {
        const val ARG_TRAIL_ID = "trailId"
        fun createRoute(trailId: String) = "trail/$trailId"
    }
}
