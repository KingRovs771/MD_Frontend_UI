package aplikasi.growumkm.login

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import aplikasi.growumkm.MainActivity
import aplikasi.growumkm.R
import aplikasi.growumkm.dashboard.ui.MainViewModelFactory
import aplikasi.growumkm.databinding.ActivityNewSplashScreenBinding
import aplikasi.growumkm.login.handler.SplashScreenViewModel
import aplikasi.growumkm.util.isAppOnline

class NewSplashScreen : AppCompatActivity() {

    private lateinit var binding : ActivityNewSplashScreenBinding
    private val viewModel : SplashScreenViewModel by viewModels{
        MainViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding = ActivityNewSplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler(Looper.getMainLooper()).postDelayed({
            if(isAppOnline(this)){
                viewModel.getSession().observe(this){
                    if(it.isLogin){
                        val myIntent = Intent(this,MainActivity::class.java)
                        myIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(myIntent)
                    }else{
                        val myIntent = Intent(this,LoginActivity::class.java)
                        myIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(myIntent)
                    }
                }
            }else{
                showDialog()
            }
        },1000)
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.no_internet_dialog)
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val buttonBack : LinearLayout = dialog.findViewById(R.id.layout_for_close)
        val buttonBack2 : ImageView = dialog.findViewById(R.id.btn_internet_back)
        buttonBack.setOnClickListener {
            this@NewSplashScreen.recreate()
            dialog.dismiss()
        }
        buttonBack2.setOnClickListener {
            this@NewSplashScreen.recreate()
            dialog.dismiss()
        }
        dialog.show()

    }
}