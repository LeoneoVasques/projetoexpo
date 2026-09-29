package com.example.projetoexpo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.projetoexpo.data.datastore.UserPreferencesRepository
import com.example.projetoexpo.data.repository.CareerMockRepository
import com.example.projetoexpo.ui.screens.dashboard.DashboardScreen
import com.example.projetoexpo.ui.screens.onboarding.OnboardingScreen
import com.example.projetoexpo.ui.screens.splash.SplashScreen
import com.example.projetoexpo.ui.screens.trail.TrailScreen

/**
 * Gráfico Central de Navegação do App.
 */
@Composable
fun AppNavigation(
    userPreferencesRepository: UserPreferencesRepository,
    careerMockRepository: CareerMockRepository
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // 1. Rota de Splash
        composable(Screen.Splash.route) {
            SplashScreen(
                userPreferencesRepository = userPreferencesRepository,
                onNavigateToOnboarding = {
                    navController.navigate(Screen.Onboarding.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                },
                onNavigateToDashboard = {
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        // 2. Rota de Onboarding
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                userPreferencesRepository = userPreferencesRepository,
                onNavigateToDashboard = {
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                }
            )
        }

        // 3. Rota de Dashboard
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                userPreferencesRepository = userPreferencesRepository,
                careerMockRepository = careerMockRepository,
                onNavigateToTrail = { trailId ->
                    navController.navigate(Screen.Trail.createRoute(trailId))
                },
                onNavigateToOnboarding = {
                    navController.navigate(Screen.Onboarding.route) {
                        popUpTo(Screen.Dashboard.route) { inclusive = true }
                    }
                }
            )
        }

        // 4. Rota Dinâmica da Trilha
        composable(
            route = Screen.Trail.route,
            arguments = listOf(
                navArgument(Screen.Trail.ARG_TRAIL_ID) {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) { backStackEntry ->
            val trailId = backStackEntry.arguments?.getString(Screen.Trail.ARG_TRAIL_ID) ?: ""
            TrailScreen(
                trailId = trailId,
                careerMockRepository = careerMockRepository,
                userPreferencesRepository = userPreferencesRepository,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
