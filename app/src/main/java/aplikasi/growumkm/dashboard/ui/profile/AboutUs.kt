package aplikasi.growumkm.dashboard.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import aplikasi.growumkm.R

class AboutUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)


        val buttonBack : ImageView = findViewById(R.id.btn_back_about_us)
        buttonBack.setOnClickListener {
            finish()
        }
    }
}