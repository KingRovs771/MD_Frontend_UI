package aplikasi.data.api.di

import android.content.Context
import aplikasi.data.api.ApiConfig
import aplikasi.data.api.pref.UserPreferences
import aplikasi.data.api.pref.dataStore
import aplikasi.data.repository.DataRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): DataRepository {
        val pref = UserPreferences.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig(user.token).getServiceWithAPI
        return DataRepository.getInstance(pref,apiService)
    }
}