package aplikasi.growumkm.util

import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.Window
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import aplikasi.growumkm.R
import aplikasi.growumkm.View.customView.MyCustomButton
import aplikasi.growumkm.View.customView.MyEmailEditText
import aplikasi.growumkm.View.customView.MyPasswordEditText
import java.text.NumberFormat


fun getRupiahFormat(number: Int): String {
    val data = number.toDouble()
    return "Rp. ${NumberFormat.getInstance().format(data)}"
}

fun isAppOnline(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (connectivityManager != null) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                return true
            }
        }
    }
    return false
}

fun checkRequireChar2(myEmailEditText: MyEmailEditText, myPasswordEditText: MyPasswordEditText, myCustomButton: MyCustomButton){
    myEmailEditText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if(Patterns.EMAIL_ADDRESS.matcher(text!!).matches()){
                myPasswordEditText.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        myCustomButton.isEnabled = text!!.length >= 8
                    }
                    override fun afterTextChanged(p0: Editable?) {}
                })
            }else{
                myCustomButton.isEnabled = false
            }
        }
        override fun afterTextChanged(p0: Editable?) {}
    })
}

fun formatAngkaJuta(angka: Int): String {
    return when {
        angka >= 1000000 -> "${angka / 1000000}JT"
        else -> angka.toString()
    }
}

fun showLoadingCostum(owner : LifecycleOwner, context: Context, liveData: LiveData<Boolean>){
    val dialog = Dialog(context)

    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(R.layout.progress_bar_costum)
    dialog.setCanceledOnTouchOutside(false)
    dialog.show()
    liveData.observe(owner){
        if(it){
            dialog.show()
        }
        else{
            dialog.dismiss()
        }
    }
}


