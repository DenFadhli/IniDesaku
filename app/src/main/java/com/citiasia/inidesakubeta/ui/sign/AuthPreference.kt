//package com.citiasia.inidesakubeta.ui.sign
//
//import android.content.Context
//import androidx.datastore.core.DataStore
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.core.booleanPreferencesKey
//import androidx.datastore.preferences.core.edit
//import androidx.datastore.preferences.core.stringPreferencesKey
//import kotlinx.coroutines.flow.first
//
//class AuthPreference(private val context: Context) {
//    private val dataStore: DataStore<Preferences> = context.createDataStore(name = "user_prefs")
//
//    companion object {
//        val USER_LOGIN_STATUS = booleanPreferencesKey("user_login_status")
//        val USER_ID = stringPreferencesKey("user_id")
//    }
//
//    suspend fun saveLoggedInUserId(userId: String) {
//        dataStore.edit { preferences ->
//            preferences[USER_LOGIN_STATUS] = true
//            preferences[USER_ID] = userId
//        }
//    }
//
//    suspend fun isLoggedIn(): Boolean {
//        val preferences = dataStore.data.first()
//        return preferences[USER_LOGIN_STATUS] ?: false
//    }
//
//    suspend fun getLoggedInUserId(): String {
//        val preferences = dataStore.data.first()
//        return preferences[USER_ID] ?: ""
//    }
//
//    suspend fun logout() {
//        dataStore.edit { preferences ->
//            preferences.clear()
//        }
//    }
//}
