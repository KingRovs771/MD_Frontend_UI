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
import aplikasi.growumkm.R
import aplikasi.growumkm.util.isAppOnline

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler(Looper.getMainLooper())
            .postDelayed({
                         if(isAppOnline(this)){
                             startActivity(Intent(this,LoginActivity::class.java))
                             finish()
                         }else{
                             showDialog()
                         }
        },2000)

    }
    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.no_internet_dialog)
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val buttonBack : ImageView = dialog.findViewById(R.id.btn_internet_back)
        buttonBack.setOnClickListener {
            this@SplashScreenActivity.recreate()
            dialog.dismiss()
        }
        dialog.show()

    }
}