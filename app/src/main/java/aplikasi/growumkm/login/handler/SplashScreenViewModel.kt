package aplikasi.growumkm.login.handler

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import aplikasi.data.api.pref.UserModel
import aplikasi.data.repository.DataRepository

class SplashScreenViewModel(private val repository: DataRepository) : ViewModel() {
    fun getSession() : LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }
}