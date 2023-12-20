package aplikasi.growumkm.dashboard.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVideoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val webView = binding.webViewVideo
        val buttonBack = binding.btnBackVid

        webView.settings.javaScriptEnabled = true
        webView.loadUrl(WEB_URL)

        buttonBack.setOnClickListener {
            finish()
        }

    }


    companion object{
        private var WEB_URL = "https://growumkm.my.canva.site/profil-video"
    }
}