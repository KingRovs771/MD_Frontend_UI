package aplikasi.growumkm.dashboard.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.ActivityInvestBinding

class InvestActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInvestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInvestBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBackInvest.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnNominal1Invest.setOnClickListener {
            Toast.makeText(this,"saya ditekan",Toast.LENGTH_SHORT).show()
        }
    }
}