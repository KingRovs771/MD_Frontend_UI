package aplikasi.growumkm.dashboard.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import aplikasi.growumkm.R

class MulaiUmkmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulai_umkm)
        val buttonBack : Button = findViewById(R.id.btn_back_coming_soon)
        buttonBack.setOnClickListener {
            finish()
        }
    }
}