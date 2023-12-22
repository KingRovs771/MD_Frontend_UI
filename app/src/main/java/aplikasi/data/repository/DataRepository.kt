package aplikasi.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import aplikasi.data.api.ApiService
import aplikasi.data.api.UmkmData
import aplikasi.data.api.paging.UmkmPagingResource
import aplikasi.data.api.pref.UserModel
import aplikasi.data.api.pref.UserPreferences
import kotlinx.coroutines.flow.Flow

class DataRepository private constructor(
    private val userPreferences: UserPreferences,
    private val apiService: ApiService
){
    suspend fun saveSession(userModel: UserModel){
        userPreferences.saveSession(userModel)
    }

    fun getSession() : Flow<UserModel> {
        return userPreferences.getSession()
    }
    suspend fun logout(){
        userPreferences.logout()
    }

    fun getUmkmData() : LiveData<PagingData<UmkmData>>{
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                UmkmPagingResource(apiService)
            }
        ).liveData
    }
    companion object {
        @Volatile
        private var instance: DataRepository? = null
        fun getInstance(
            userPreference: UserPreferences,
            apiService: ApiService
        ): DataRepository =
            instance ?: synchronized(this) {
                instance ?: DataRepository(userPreference, apiService)
            }.also { instance = it }
    }
}