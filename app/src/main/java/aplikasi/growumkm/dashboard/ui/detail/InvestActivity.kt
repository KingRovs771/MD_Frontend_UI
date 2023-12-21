package aplikasi.growumkm.dashboard.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.set
import androidx.core.widget.addTextChangedListener
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.ActivityInvestBinding
import aplikasi.growumkm.util.getRupiahFormat
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class InvestActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInvestBinding
    private var valueInvest : String? = "Rp. 0"
    private lateinit var btnInvest : ExtendedFloatingActionButton
    private lateinit var nominalInvest : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInvestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnInvest = binding.btnInvestInvest
        nominalInvest = binding.tvInvestNominal

        btnInvest.setOnClickListener {
            Toast.makeText(this,"Telah investasi sebanyal $valueInvest",Toast.LENGTH_SHORT).show()
        }
        handleInvest()
    }


    private fun handleInvest(){

        binding.btnBackInvest.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnNominal1Invest.setOnClickListener {

            valueInvest = getRupiahFormat(ITEM_1)
            nominalInvest.text = valueInvest
        }

        binding.btnNominal2Invest.setOnClickListener {
            valueInvest = getRupiahFormat(ITEM_2)
            nominalInvest.text = valueInvest
        }

        binding.btnNominal3Invest.setOnClickListener {
            valueInvest = getRupiahFormat(ITEM_3)
            nominalInvest.text = valueInvest
        }
        binding.btnNominal4Invest.setOnClickListener {
            valueInvest = getRupiahFormat(ITEM_4)
            nominalInvest.text = valueInvest
        }
        binding.btnNominal5Invest.setOnClickListener {
            valueInvest = getRupiahFormat(ITEM_5)
            nominalInvest.text = valueInvest
        }

    }

    companion object{
        private const val ITEM_1 = 100000
        private const val ITEM_2 = 200000
        private const val ITEM_3 = 300000
        private const val ITEM_4 = 500000
        private const val ITEM_5 = 1000000

    }
}
