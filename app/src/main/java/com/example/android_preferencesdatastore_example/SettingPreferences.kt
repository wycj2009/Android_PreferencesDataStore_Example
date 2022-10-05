package com.example.android_preferencesdatastore_example

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

object SettingPreferences {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "setting")

    fun getInt(context: Context, key: String, defaultValue: Int): Int {
        return runBlocking {
            getIntFlow(context, key).firstOrNull() ?: defaultValue
        }
    }

    fun getIntFlow(context: Context, key: String): Flow<Int?> {
        return context.dataStore.data.map { preferences ->
            preferences[intPreferencesKey(key)]
        }
    }

    fun put(context: Context, key: String, value: Int) {
        runBlocking {
            context.dataStore.edit { preferences ->
                preferences[intPreferencesKey(key)] = value
            }
        }
    }

    fun getDouble(context: Context, key: String, defaultValue: Double): Double {
        return runBlocking {
            getDoubleFlow(context, key).firstOrNull() ?: defaultValue
        }
    }

    fun getDoubleFlow(context: Context, key: String): Flow<Double?> {
        return context.dataStore.data.map { preferences ->
            preferences[doublePreferencesKey(key)]
        }
    }

    fun put(context: Context, key: String, value: Double) {
        runBlocking {
            context.dataStore.edit { preferences ->
                preferences[doublePreferencesKey(key)] = value
            }
        }
    }

    fun getString(context: Context, key: String, defaultValue: String): String {
        return runBlocking {
            getStringFlow(context, key).firstOrNull() ?: defaultValue
        }
    }

    fun getStringFlow(context: Context, key: String): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[stringPreferencesKey(key)]
        }
    }

    fun put(context: Context, key: String, value: String) {
        runBlocking {
            context.dataStore.edit { preferences ->
                preferences[stringPreferencesKey(key)] = value
            }
        }
    }

    fun getBoolean(context: Context, key: String, defaultValue: Boolean): Boolean {
        return runBlocking {
            getBooleanFlow(context, key).firstOrNull() ?: defaultValue
        }
    }

    fun getBooleanFlow(context: Context, key: String): Flow<Boolean?> {
        return context.dataStore.data.map { preferences ->
            preferences[booleanPreferencesKey(key)]
        }
    }

    fun put(context: Context, key: String, value: Boolean) {
        runBlocking {
            context.dataStore.edit { preferences ->
                preferences[booleanPreferencesKey(key)] = value
            }
        }
    }

    fun getFloat(context: Context, key: String, defaultValue: Float): Float {
        return runBlocking {
            getFloatFlow(context, key).firstOrNull() ?: defaultValue
        }
    }

    fun getFloatFlow(context: Context, key: String): Flow<Float?> {
        return context.dataStore.data.map { preferences ->
            preferences[floatPreferencesKey(key)]
        }
    }

    fun put(context: Context, key: String, value: Float) {
        runBlocking {
            context.dataStore.edit { preferences ->
                preferences[floatPreferencesKey(key)] = value
            }
        }
    }

    fun getLong(context: Context, key: String, defaultValue: Long): Long {
        return runBlocking {
            getLongFlow(context, key).firstOrNull() ?: defaultValue
        }
    }

    fun getLongFlow(context: Context, key: String): Flow<Long?> {
        return context.dataStore.data.map { preferences ->
            preferences[longPreferencesKey(key)]
        }
    }

    fun put(context: Context, key: String, value: Long) {
        runBlocking {
            context.dataStore.edit { preferences ->
                preferences[longPreferencesKey(key)] = value
            }
        }
    }

    fun getStringSet(context: Context, key: String, defaultValue: Set<String>): Set<String> {
        return runBlocking {
            getStringSetFlow(context, key).firstOrNull() ?: defaultValue
        }
    }

    fun getStringSetFlow(context: Context, key: String): Flow<Set<String>?> {
        return context.dataStore.data.map { preferences ->
            preferences[stringSetPreferencesKey(key)]
        }
    }

    fun put(context: Context, key: String, value: Set<String>) {
        runBlocking {
            context.dataStore.edit { preferences ->
                preferences[stringSetPreferencesKey(key)] = value
            }
        }
    }

    object KeySet {
        const val KEY_INT = "key_int"
        const val KEY_DOUBLE = "key_double"
        const val KEY_STRING = "key_string"
        const val KEY_BOOLEAN = "key_boolean"
        const val KEY_FLOAT = "key_float"
        const val KEY_LONG = "key_long"
        const val KEY_STRING_SET = "key_string_set"
    }
}
