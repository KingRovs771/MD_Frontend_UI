package aplikasi.growumkm.dashboard.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import aplikasi.growumkm.R
import aplikasi.growumkm.dashboard.ui.detail.handler.DetailSectionPagerAdapter
import aplikasi.growumkm.databinding.ActivityDetailBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.makeramen.roundedimageview.RoundedImageView

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private lateinit var toolBarTitleUMKM : TextView
    private lateinit var imgUMKM : RoundedImageView
    private lateinit var tvNameUMKM : TextView
    private lateinit var tvTagCategoryUMKM : TextView
    private lateinit var tvTerkumpulValue : TextView
    private lateinit var tvDetailInvestor : TextView
    private lateinit var tvDetailSisaHari : TextView

    private lateinit var buttonInvest : ExtendedFloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonInvest = binding.fabInvest
        toolBarTitleUMKM = binding.toolbarTitle
        imgUMKM = binding.imgUmkmDetail
        tvNameUMKM = binding.tvNameUmkm
        tvTagCategoryUMKM = binding.tvTagCategory
        tvTerkumpulValue = binding.tvTerkumpulValue
        tvDetailInvestor = binding.tvDetailInvestor
        tvDetailSisaHari = binding.tvDetailSisaHari

        buttonInvest.setOnClickListener {
            startActivity(Intent(this,InvestActivity::class.java))
        }
        setupTabLayout()
    }


    private fun setAddToFavorite(isFavorite : Boolean){
        if(isFavorite){
            binding.btnAddToFavorite.setImageResource(R.drawable.ic_favorite)
        }else{
            binding.btnAddToFavorite.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    private fun setupTabLayout(){
        val actionBar = binding.toolbarDetailHolder
        val buttonBack = binding.btnBackDetail
        val detailSectionPagerAdapter = DetailSectionPagerAdapter(this)
        val viewPager : ViewPager2 = binding.detailViewPager
        viewPager.adapter = detailSectionPagerAdapter

        val tabs : TabLayout = binding.tabLayoutDetail

        TabLayoutMediator(tabs,viewPager){ tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        actionBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.message_menu_detail -> {
                    Toast.makeText(this, "Saya adalah menu chat", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        buttonBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.desc_detail,
            R.string.doc_detail,
            R.string.rating_detail
        )
    }
}