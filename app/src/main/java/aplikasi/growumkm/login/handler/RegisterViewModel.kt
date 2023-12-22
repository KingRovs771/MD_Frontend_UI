package aplikasi.growumkm.login.handler

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import aplikasi.data.api.ApiConfig
import aplikasi.data.api.ResponseRegister
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegisterViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading


    private val _messageLogin : MutableLiveData<String> = MutableLiveData()
    val messageLogin : LiveData<String> = _messageLogin


    fun getRegisterResponse(
        idProvinsi : Int,
        nik : String,
        namaLengkap : String,
        tglLahir : String,
        noHp : String,
        alamat : String,
        email : String,
        password : String
    ){
        _isLoading.value = true
        Log.d("LOADING","${isLoading.value}")

        viewModelScope.launch {
            try{

                val client = ApiConfig.getServiceWithOutToken
                val resp = client.register(idProvinsi,nik,namaLengkap,tglLahir,noHp,alamat,email,password)
                Log.d("REQUEST",resp.values.toString())
                Log.d("LOADING","${isLoading.value}")
                _messageLogin.postValue(resp.values.toString())
                _isLoading.postValue(false)
            }catch (e : HttpException){

                Log.d("LOADING","${isLoading.value}")
                val errorBody = e.response()?.errorBody()?.string()
                val errorResponse = Gson().fromJson(errorBody, ResponseRegister::class.java)
                Log.d("REQUEST Error",errorResponse.values.toString())
                _messageLogin.postValue(errorResponse.values.toString())
                _isLoading.postValue(false)
            }
        }
    }
}