package aplikasi.growumkm.dashboard.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import aplikasi.data.api.di.Injection
import aplikasi.data.repository.DataRepository
import aplikasi.growumkm.dashboard.ui.home.handler.HomeViewModel
import aplikasi.growumkm.dashboard.ui.profile.handler.ProfileViewModel
import aplikasi.growumkm.login.handler.LoginViewModel
import aplikasi.growumkm.login.handler.RegisterViewModel
import aplikasi.growumkm.login.handler.SplashScreenViewModel

class MainViewModelFactory(private val repository: DataRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHEKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(HomeViewModel::class.java) ->{
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) ->{
                LoginViewModel(repository) as T
            }
            modelClass.isAssignableFrom(SplashScreenViewModel::class.java) ->{
                SplashScreenViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ProfileViewModel::class.java) ->{
                ProfileViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Not found for live data")
        }
    }
    companion object{
        @Volatile
        var INSTANCE : MainViewModelFactory? = null

        @JvmStatic
        fun getInstance(context : Context) : MainViewModelFactory{
            if(INSTANCE == null){
                synchronized(MainViewModelFactory::class.java){
                    INSTANCE = MainViewModelFactory(Injection.provideRepository(context))
                }
            }

            return  INSTANCE as MainViewModelFactory
        }
    }
}