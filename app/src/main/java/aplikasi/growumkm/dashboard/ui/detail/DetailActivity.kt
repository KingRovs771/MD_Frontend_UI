package aplikasi.growumkm.dashboard.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.ActivityDetailBinding
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = binding.toolbarDetailHolder
        val buttonBack = binding.btnBackDetail
        val buttonInvest = binding.fabInvest
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

        buttonInvest.setOnClickListener {
            startActivity(Intent(this,InvestActivity::class.java))
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