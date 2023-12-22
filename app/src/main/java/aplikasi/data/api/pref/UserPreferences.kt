package aplikasi.data.api.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")
class UserPreferences private constructor(private val dataStore: DataStore<Preferences>){

    suspend fun saveSession(userModel: UserModel){
        dataStore.edit {
            it[TOKEN_KEY] = userModel.token
            it[IS_LOGIN_KEY] = true
        }
    }

    fun getSession() : Flow<UserModel> {
        return dataStore.data.map {
            UserModel(
                it[TOKEN_KEY] ?: "",
                it[IS_LOGIN_KEY] ?: false
            )
        }
    }

    suspend fun logout(){
        dataStore.edit {
            it.clear()
            it[IS_LOGIN_KEY] = false
        }
    }
    companion object{
        @Volatile
        private var userPreferences_INSTANCE : UserPreferences? = null
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val IS_LOGIN_KEY = booleanPreferencesKey("is_login")

        fun getInstance(dataStore: DataStore<Preferences>) : UserPreferences{
            return userPreferences_INSTANCE ?: synchronized(this){
                val instance = UserPreferences(dataStore)
                userPreferences_INSTANCE = instance
                instance
            }
        }
    }
}