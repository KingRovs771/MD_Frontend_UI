package aplikasi.growumkm.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import aplikasi.growumkm.MainActivity
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var btnMasuk : Button
    private lateinit var btnRegister : Button
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnMasuk = binding.buttonMasuk
        btnRegister = binding.buttonRegist

        btnMasuk.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}