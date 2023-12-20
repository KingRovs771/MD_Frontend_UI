package aplikasi.growumkm.dashboard.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import aplikasi.growumkm.R

class TermPolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_term_policy)

        val button : ImageView = findViewById(R.id.btn_back_term_policy)
        button.setOnClickListener {
            finish()
        }

    }
}