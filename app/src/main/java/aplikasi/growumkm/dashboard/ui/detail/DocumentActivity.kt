package aplikasi.growumkm.dashboard.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.ActivityDocumentBinding

class DocumentActivity : AppCompatActivity() {

    private lateinit var binding :  ActivityDocumentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDocumentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView = binding.webViewDocument
        val buttonBack = binding.btnBackDoc

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        webView.settings.javaScriptEnabled = true
        webView.loadUrl(WEB_URL)

        buttonBack.setOnClickListener {
            finish()
        }

    }
    companion object{
        private val WEB_URL = "https://growumkm.my.canva.site/"
    }
}