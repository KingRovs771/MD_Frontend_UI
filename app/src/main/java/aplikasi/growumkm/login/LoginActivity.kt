package aplikasi.growumkm.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import aplikasi.growumkm.MainActivity
import aplikasi.growumkm.R
import aplikasi.growumkm.View.customView.MyCustomButton
import aplikasi.growumkm.View.customView.MyEmailEditText
import aplikasi.growumkm.View.customView.MyPasswordEditText
import aplikasi.growumkm.databinding.ActivityLoginBinding
import aplikasi.growumkm.util.checkRequireChar2

class LoginActivity : AppCompatActivity() {
    private lateinit var btnMasuk : MyCustomButton
    private lateinit var btnRegister : TextView
    private lateinit var binding : ActivityLoginBinding

    private lateinit var edEmail : MyEmailEditText
    private lateinit var edPass : MyPasswordEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        playAnimation()


        btnMasuk = binding.loginButton
        btnRegister = binding.register

        edEmail = binding.emailEditText
        edPass = binding.passwordEditText

        checkRequireChar2(binding.emailEditText,binding.passwordEditText,binding.loginButton)

        btnMasuk.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }



    }
    private fun playAnimation() {
        val title = ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA,1F).setDuration(500)
        val message = ObjectAnimator.ofFloat(binding.messageTextView, View.ALPHA,1F).setDuration(500)

        val emailTextView = ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA,1F).setDuration(500)
        val emailEditText = ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA,1F).setDuration(500)

        val passTextView = ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA,1F).setDuration(500)
        val passEditText = ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA,1F).setDuration(500)


        val register = ObjectAnimator.ofFloat(binding.register, View.ALPHA,1F).setDuration(500)


        val button = ObjectAnimator.ofFloat(binding.loginButton, View.ALPHA,1F).setDuration(500)

        val email = AnimatorSet().apply {
            play(emailTextView).with(emailEditText)
        }

        val pass = AnimatorSet().apply {
            playTogether(passEditText,passTextView)
        }

        AnimatorSet().apply {
            playSequentially(title,message,email,pass,button,register)
            start()
        }


    }
}