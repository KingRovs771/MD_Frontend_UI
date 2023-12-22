package aplikasi.growumkm.dashboard.ui.profile.handler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import aplikasi.data.repository.DataRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: DataRepository) :ViewModel() {
    fun logout(){
        viewModelScope.launch {
            repository.logout()
            repository.getSession()
        }
    }
}