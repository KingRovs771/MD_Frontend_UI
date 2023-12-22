package aplikasi.growumkm.login.handler

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import aplikasi.data.api.ApiConfig
import aplikasi.data.api.ResponseLogin
import aplikasi.data.api.pref.UserModel
import aplikasi.data.repository.DataRepository
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel(private val repository: DataRepository)  : ViewModel() {
    private val _messageLogin : MutableLiveData<String> = MutableLiveData()
    val messageLogin : LiveData<String> = _messageLogin


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _isUser = MutableLiveData<Boolean>()
    val isUser : LiveData<Boolean> = _isUser

    fun getSession() : LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }
    fun getLoginResponse(email : String, password : String){
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val client = ApiConfig.getServiceWithOutToken.login(email, password)
                Log.d("CLIENT","TOKEN CLIENT ADALAH ${client?.token}")
                _isLoading.postValue(false)
                if (client?.token != null){
                    Log.d("REQUEST LOGIN", "$client")
                    val userModel = UserModel(client.token,true)
                    Log.d("REQUEST LOGIN MODEL","$userModel")
                    _isUser.postValue(true)
                    repository.logout()
                    repository.saveSession(userModel)
                    _messageLogin.postValue(client.message as String)
                    Log.d("REQUEST LOGIN Message","${messageLogin.value}")
                }else{
                   _isUser.postValue(false)
                }
            }catch (e : HttpException){
                _isLoading.postValue(false)
                val errorBody = e.response()?.errorBody()?.string()
                val errorResponse = Gson().fromJson(errorBody, ResponseLogin::class.java)

                _messageLogin.postValue(errorResponse.message.toString())
                Log.d("REQUEST Error",errorResponse.message.toString())
            }
        }
    }
}