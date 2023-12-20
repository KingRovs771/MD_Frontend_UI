package aplikasi.growumkm.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegist.setOnClickListener {
            finish()
        }
    }
}