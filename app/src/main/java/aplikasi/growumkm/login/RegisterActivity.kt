package aplikasi.growumkm.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import aplikasi.growumkm.R
import aplikasi.growumkm.View.customView.MyCustomButton
import aplikasi.growumkm.databinding.ActivityRegisterBinding
import aplikasi.growumkm.util.checkRequireChar2

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var nameUser : TextView
    private lateinit var emailUser : TextView
    private lateinit var passUser : TextView
    private lateinit var city : TextView
    private lateinit var phone : TextView

    private lateinit var btnRegister : MyCustomButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameUser = binding.edNameRegist
        emailUser = binding.edEmailRegist
        passUser = binding.edPasswordRegist
        city = binding.edKotaRegist
        phone = binding.edTelpRegist
        btnRegister = binding.registButton


        checkRequireChar2(binding.edEmailRegist,binding.edPasswordRegist,binding.registButton)
        btnRegister.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

    }
}