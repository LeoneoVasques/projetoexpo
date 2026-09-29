package com.example.projetoexpo.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

// Extensão de Context para criar uma única instância do DataStore (Singleton)
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

/**
 * Modelo com os dados do usuário salvos localmente.
 * (Equivalente a um tipo TypeScript ou payload de sessão).
 */
data class UserPreferences(
    val userName: String = "",
    val chosenArea: String = "",
    val isOnboardingCompleted: Boolean = false
)

/**
 * Repositório responsável por gerenciar a persistência local com DataStore.
 * (Equivalente a um serviço que gerencia localStorage/AsyncStorage no Web).
 */
class UserPreferencesRepository(private val context: Context) {

    private companion object {
        val KEY_USER_NAME = stringPreferencesKey("user_name")
        val KEY_CHOSEN_AREA = stringPreferencesKey("chosen_area")
        val KEY_ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
    }

    /**
     * Flow reativo que emite os dados do usuário sempre que houver alteração.
     * (Equivalente a uma subscrição / Observable / Hook reativo no React).
     */
    val userPreferencesFlow: Flow<UserPreferences> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            UserPreferences(
                userName = preferences[KEY_USER_NAME] ?: "",
                chosenArea = preferences[KEY_CHOSEN_AREA] ?: "",
                isOnboardingCompleted = preferences[KEY_ONBOARDING_COMPLETED] ?: false
            )
        }

    /**
     * Salva o nome e a área de interesse escolhidos no Onboarding e marca como concluído.
     * (Função 'suspend' é o equivalente a uma função 'async' no JS/TS).
     */
    suspend fun saveUserPreferences(name: String, chosenArea: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_USER_NAME] = name.trim()
            preferences[KEY_CHOSEN_AREA] = chosenArea.trim()
            preferences[KEY_ONBOARDING_COMPLETED] = true
        }
    }

    /**
     * Permite atualizar apenas a área de interesse mantendo o nome do usuário.
     */
    suspend fun updateChosenArea(newArea: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_CHOSEN_AREA] = newArea.trim()
        }
    }

    /**
     * Limpa os dados salvos (útil para botão de Reset/Logout na apresentação).
     */
    suspend fun clearUserPreferences() {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}
