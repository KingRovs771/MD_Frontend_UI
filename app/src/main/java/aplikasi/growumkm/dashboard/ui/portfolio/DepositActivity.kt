package aplikasi.growumkm.dashboard.ui.portfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.ActivityDepositBinding
import aplikasi.growumkm.util.getRupiahFormat

class DepositActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDepositBinding
    private var valueTopUp : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDepositBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nominalTopUp = binding.tvTopupNominal

        binding.btnTopup1.setOnClickListener {
            valueTopUp = getRupiahFormat(100000)
            nominalTopUp.text = valueTopUp
        }

        binding.btnTopup2.setOnClickListener {
            valueTopUp = getRupiahFormat(200000)
            nominalTopUp.text = valueTopUp
        }

        binding.btnTopup3.setOnClickListener {
            valueTopUp = getRupiahFormat(300000)
            nominalTopUp.text = valueTopUp
        }
        binding.btnTopup4.setOnClickListener {
            valueTopUp = getRupiahFormat(500000)
            nominalTopUp.text = valueTopUp
        }
        binding.btnTopup5.setOnClickListener {
            valueTopUp = getRupiahFormat(1000000)
            nominalTopUp.text = valueTopUp
        }

        binding.btnBackTopup.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}