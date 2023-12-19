package aplikasi.growumkm.dashboard.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.text.set
import androidx.core.widget.addTextChangedListener
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.ActivityInvestBinding
import aplikasi.growumkm.util.getRupiahFormat

class InvestActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInvestBinding
    private var valueInvest : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInvestBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBackInvest.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        val nominalInvest = binding.tvInvestNominal
        binding.btnNominal1Invest.setOnClickListener {

            valueInvest = getRupiahFormat(100000)
            nominalInvest.text = valueInvest
        }

        binding.btnNominal2Invest.setOnClickListener {
        valueInvest = getRupiahFormat(200000)
        nominalInvest.text = valueInvest
        }

        binding.btnNominal3Invest.setOnClickListener {
            valueInvest = getRupiahFormat(300000)
            nominalInvest.text = valueInvest
        }
        binding.btnNominal4Invest.setOnClickListener {
            valueInvest = getRupiahFormat(500000)
            nominalInvest.text = valueInvest
        }
        binding.btnNominal5Invest.setOnClickListener {
            valueInvest = getRupiahFormat(1000000)
            nominalInvest.text = valueInvest
        }

    }


}