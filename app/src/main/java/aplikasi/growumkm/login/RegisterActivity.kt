package aplikasi.growumkm.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import aplikasi.growumkm.R
import aplikasi.growumkm.View.customView.MyCustomButton
import aplikasi.growumkm.databinding.ActivityRegisterBinding
import aplikasi.growumkm.login.handler.RegisterViewModel
import aplikasi.growumkm.util.checkRequireChar2
import aplikasi.growumkm.util.showLoadingCostum
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RegisterActivity : AppCompatActivity(),DatePickerFragment.DialogDateListener {

    private val registerViewModel : RegisterViewModel by viewModels()
    private lateinit var binding : ActivityRegisterBinding
    private lateinit var nameUser : TextView
    private lateinit var emailUser : TextView
    private lateinit var passUser : TextView
    private lateinit var alamat : TextView
    private lateinit var phone : TextView

    private lateinit var btnRegister : MyCustomButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        checkRequireChar2(binding.edEmailRegist,binding.edPasswordRegist,binding.registButton)
        binding.registButton.setOnClickListener {
            setupRegister()
        }
        binding.btnDate.setOnClickListener {
            val datePickerFragment = DatePickerFragment()
            datePickerFragment.show(supportFragmentManager, DATE_PICKER_TAG)
        }

    }

    fun setupRegister(){
        val idProvinsi = binding.spinnerItem.selectedItemId.toInt()
        val nik = binding.edNikRegist.text.toString()
        val namaLengkap = binding.edNameRegist.text.toString()
        val tanggalLahir = binding.tvDateRegist.text.toString()
        val noHp = binding.edTelpRegist.text.toString()
        val alamat = binding.edAlamatRegist.text.toString()
        val email = binding.edEmailRegist.text.toString()
        val password = binding.edPasswordRegist.text.toString()

        registerViewModel.getRegisterResponse(
            idProvinsi,
            nik,
            namaLengkap,
            tanggalLahir,
            noHp,
            alamat, email, password
        )
        showLoadingCostum(this,this,registerViewModel.isLoading)
        registerViewModel.messageLogin.observe(this){
            if(it.equals("Berhasil Menambahkan Data User Baru")){
                Toast.makeText(this, "berhasil membuat akun",Toast.LENGTH_SHORT).show()
                Log.d("INSIDE REG","BERHASIL REGISTER")
                val myIntent = Intent(this,LoginActivity::class.java)
                startActivity(myIntent)
            }else{
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        }



    }

    override fun onDialogDateSet(tag: String?, year: Int, month: Int, dayOfMonth: Int) {


        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        binding.tvDateRegist.text = dateFormat.format(calendar.time)


    }



    companion object {
        private const val DATE_PICKER_TAG = "DatePicker"
    }
}