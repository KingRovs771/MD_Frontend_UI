package aplikasi.growumkm.dashboard.ui.portfolio.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.ActivityDepositBinding
import aplikasi.growumkm.util.getRupiahFormat
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DepositActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDepositBinding
    private lateinit var btnTopUp : ExtendedFloatingActionButton
    private var valueTopUp : String? = "Rp. 0"
    private lateinit var nominalTopUp : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDepositBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nominalTopUp = binding.tvTopupNominal
        btnTopUp = binding.btnTopupTopup

        btnTopUp.setOnClickListener {
            Toast.makeText(this,"Telah investasi sebanyal $valueTopUp", Toast.LENGTH_SHORT).show()
        }
        handleTopUp()
    }
    private fun handleTopUp(){
        binding.btnTopup1.setOnClickListener {
            valueTopUp = getRupiahFormat(ITEM_1)
            nominalTopUp.text = valueTopUp
        }

        binding.btnTopup2.setOnClickListener {
            valueTopUp = getRupiahFormat(ITEM_2)
            nominalTopUp.text = valueTopUp
        }

        binding.btnTopup3.setOnClickListener {
            valueTopUp = getRupiahFormat(ITEM_3)
            nominalTopUp.text = valueTopUp
        }
        binding.btnTopup4.setOnClickListener {
            valueTopUp = getRupiahFormat(ITEM_4)
            nominalTopUp.text = valueTopUp
        }
        binding.btnTopup5.setOnClickListener {
            valueTopUp = getRupiahFormat(ITEM_5)
            nominalTopUp.text = valueTopUp
        }

        binding.btnBackTopup.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
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