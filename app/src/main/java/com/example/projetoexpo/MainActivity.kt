package com.example.projetoexpo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.projetoexpo.data.datastore.UserPreferencesRepository
import com.example.projetoexpo.data.repository.CareerMockRepository
import com.example.projetoexpo.ui.navigation.AppNavigation
import com.example.projetoexpo.ui.theme.GPSCarreiraTheme

class MainActivity : ComponentActivity() {

    // Repositórios instanciados para o escopo da aplicação
    private val userPreferencesRepository by lazy { UserPreferencesRepository(applicationContext) }
    private val careerMockRepository by lazy { CareerMockRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GPSCarreiraTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation(
                        userPreferencesRepository = userPreferencesRepository,
                        careerMockRepository = careerMockRepository
                    )
                }
            }
        }
    }
}