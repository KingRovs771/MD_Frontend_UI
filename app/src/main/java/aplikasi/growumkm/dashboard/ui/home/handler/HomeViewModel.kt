package aplikasi.growumkm.dashboard.ui.home.handler

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import aplikasi.data.api.pref.UserModel
import aplikasi.data.repository.DataRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: DataRepository) : ViewModel() {

    fun getAllDataUmkm() = repository.getUmkmData().cachedIn(viewModelScope)

}