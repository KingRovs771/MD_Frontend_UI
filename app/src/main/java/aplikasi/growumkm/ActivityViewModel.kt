package aplikasi.growumkm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel




// view model for handle a bug (i might it planning for handle tehee :b)
class ActivityViewModel : ViewModel(){

    private val _showBottomBarNavigation = MutableLiveData<Boolean>(false)
    private val showBottomBarNavigation : LiveData<Boolean> = _showBottomBarNavigation


    fun hideBottomBarNavigation(hide : Boolean){
        _showBottomBarNavigation.value = hide
    }

}